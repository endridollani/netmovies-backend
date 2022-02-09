package com.enterprise.netmovies.models;


import com.mongodb.client.model.Collation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.ZonedDateTime;

@Document(collection = "AUTH_USER_DETAILS")

public class User implements UserDetails {


    @Id
    private String id;



    @Indexed(unique = true)
    private String userName;
    private String password;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean enabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }
    
//    public User(){
//
//    }
//
//    public User(String firstName, String lastName, String email, String password){
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String  getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


}
