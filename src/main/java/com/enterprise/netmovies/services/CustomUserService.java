package com.enterprise.netmovies.services;

import com.enterprise.netmovies.models.User;
import com.enterprise.netmovies.repository.UserDetailsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsRepository.findUserByUserName(username);

        if(null == user){
            throw new UsernameNotFoundException("User not found with username "+ username);
        }
        return user;
    }
}
