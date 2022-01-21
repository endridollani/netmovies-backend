package com.enterprise.netmovies.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {
    private UserRepository repository;

    //Add a newly created user to Database
    public User createUser(User user) {
        return repository.insert(user);
    }

    //Get user by id
    public ResponseEntity<User> getUserById(long id) {
        User user = repository.
                findById(id).
                orElseThrow(()
                        -> new ResourceNotFoundException
                        ("User with id:"+id+" does not exist!"));
        return ResponseEntity.ok(user);
    }

    //Delete User
    public ResponseEntity<Map<String ,Boolean>> deleteUserById(long id){
        User user = repository.
                findById(id).
                orElseThrow(()
                        -> new ResourceNotFoundException
                        ("User with id:"+id+" does not exist!"));
        repository.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return  ResponseEntity.ok(response);
    }

    //Update User
    public ResponseEntity<User> updateUserById(long id,
                                                   User userUpdatePayload) {
        User user = repository.
                findById(id).
                orElseThrow(()
                        -> new ResourceNotFoundException
                        ("User with id:"+id+" does not exist!"));


        user.setFirstName(userUpdatePayload.getFirstName());
        user.setLastName(userUpdatePayload.getLastName());
        user.setEmail(userUpdatePayload.getEmail());
        user.setPassword(userUpdatePayload.getPassword());

        User updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
