package com.tyss.dockerimplementation.service.impl;

import com.tyss.dockerimplementation.dao.PersonDao;
import com.tyss.dockerimplementation.entity.Person;
import com.tyss.dockerimplementation.service.PersonService;
import com.tyss.dockerimplementation.structure.ResponseStructure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
        long currentedTimeMillis = System.currentTimeMillis();
        Person person1 = personDao.savePerson(person);
        ResponseStructure<Person> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(person1);
        structure.setResponseTime((System.currentTimeMillis()) - currentedTimeMillis);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    @Async("asyncTaskExecutor")
    @Override
    public CompletableFuture<ResponseEntity<ResponseStructure<Person>>> findPersonById(String id) {
        log.info("Current thread Name ${}", Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> {
            long currentedTimeMillis = System.currentTimeMillis();
            Person personById = personDao.findPersonById(id);
            ResponseStructure<Person> structure = new ResponseStructure<>();
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Success");
            structure.setData(personById);
            structure.setResponseTime(System.currentTimeMillis() - currentedTimeMillis);
            ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<>(structure, HttpStatus.OK);
            return responseEntity;
        });
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Person>>> findAllPerson() {
        long currentedTimeMillis = System.currentTimeMillis();
        List<Person> allPersons = personDao.findAllPersons();
        ResponseStructure<List<Person>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(allPersons);
        structure.setResponseTime((System.currentTimeMillis()) - currentedTimeMillis);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<String>> deletePerson(String id) {
        long currentedTimeMillis = System.currentTimeMillis();
        boolean result = personDao.deletePerson(id);
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData("Person deleted successfully");
        structure.setResponseTime((System.currentTimeMillis()) - currentedTimeMillis);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
}
