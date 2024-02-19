package com.tyss.dockerimplementation.controller;

import com.tyss.dockerimplementation.entity.Person;
import com.tyss.dockerimplementation.service.PersonService;
import com.tyss.dockerimplementation.structure.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<ResponseStructure<Person>>> findPersonById(@PathVariable String id) {
        return personService.findPersonById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons() {
        return personService.findAllPerson();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deletePerson(@PathVariable String id) {
        return personService.deletePerson(id);
    }
}
