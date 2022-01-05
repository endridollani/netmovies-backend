package com.enterprise.netmovies;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//It is recomanded that the query logic is build in this type of interface. Makes the code clean af.
public interface StudentRepository
        extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

}
