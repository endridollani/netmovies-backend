package com.enterprise.netmovies.repository;

import com.enterprise.netmovies.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends MongoRepository<User,String> {
    User findUserByUserName(String userName);
}
