package com.tyss.dockerimplementation.repo;

import com.tyss.dockerimplementation.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person, String> {
}
