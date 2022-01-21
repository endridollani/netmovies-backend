package com.enterprise.netmovies.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    //Post newly created user
    @PostMapping()
    public User postUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //Get user by id
    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    //Delete user
    @DeleteMapping("/api/v1/user/{id}")
    public ResponseEntity<Map<String ,Boolean>> deleteUserById(@PathVariable("id") long id){
        return userService.deleteUserById(id);
    }

    //Update user
    @PutMapping ("/api/v1/user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") long id,@RequestBody User userUpdatePayload){
        return userService.updateUserById(id, userUpdatePayload);
    }
}
