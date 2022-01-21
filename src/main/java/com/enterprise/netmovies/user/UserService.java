package com.enterprise.netmovies.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private UserDao userDataAccessObject;

    //Post a newly added user to database
    public User createUser(User user) {
        return userDataAccessObject.createUser(user);
    }

    //Get user by specified id
    public ResponseEntity<User> getUserById(long id) {
        return userDataAccessObject.getUserById(id);
    }

    //Delete user
    public ResponseEntity<Map<String ,Boolean>> deleteUserById(long id) {
        return userDataAccessObject.deleteUserById(id);
    }

    //Update user
    public ResponseEntity<User> updateUserById(long id, User userUpdatePayload) {
        return userDataAccessObject.updateUserById(id,userUpdatePayload);
    }
}
