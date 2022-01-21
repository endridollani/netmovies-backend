package com.enterprise.netmovies.user;

import org.springframework.data.mongodb.repository.MongoRepository;

//It is recomanded that the query logic is build in this type of interface. Makes the code clean af.

public interface UserRepository extends MongoRepository<User, Long> {

}
