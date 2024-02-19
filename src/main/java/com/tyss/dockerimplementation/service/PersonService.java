package com.tyss.dockerimplementation.service;

import com.tyss.dockerimplementation.entity.Person;
import com.tyss.dockerimplementation.structure.ResponseStructure;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PersonService {

    ResponseEntity<ResponseStructure<Person>> savePerson(Person person);


    CompletableFuture<ResponseEntity<ResponseStructure<Person>>> findPersonById(String id);


    ResponseEntity<ResponseStructure<List<Person>>> findAllPerson();

    ResponseEntity<ResponseStructure<String>> deletePerson(String id);
}
