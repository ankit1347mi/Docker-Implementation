package com.tyss.dockerimplementation.dao.impl;

import com.tyss.dockerimplementation.dao.PersonDao;
import com.tyss.dockerimplementation.entity.Person;
import com.tyss.dockerimplementation.repo.PersonRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonDaoImpl implements PersonDao {

    private PersonRepo personRepo;

    public PersonDaoImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person savePerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person findPersonById(String id) {
        return personRepo.findById(id).get();
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public boolean deletePerson(String id) {
        Optional<Person> byId = personRepo.findById(id);
        if (byId.isPresent()) {
            personRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
