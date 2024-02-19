package com.tyss.dockerimplementation.dao;

import com.tyss.dockerimplementation.entity.Person;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface PersonDao {

    Person savePerson(Person person);


    Person findPersonById(String id);


    List<Person> findAllPersons();

    boolean deletePerson(String id);
}
