package com.enterprise.netmovies.controllers;

import com.enterprise.netmovies.models.User;
import com.enterprise.netmovies.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AppController {
    @Autowired
    private UserDetailsRepository repository;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public String testApp(){
        return "Hello Spring Security!";
    }


    @PutMapping("/add/series/history/{id}")
    public ResponseEntity<?> updateHistorySeriesList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.setHistorySeries(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/add/movie/history/{id}")
    public ResponseEntity<?> updateHistoryMovieList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.setHistoryMovies(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/add/movie/watchlist/{id}")
    public ResponseEntity<?> updateWatchlistMovieList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.setWatchListMovies(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/add/series/watchlist/{id}")
    public ResponseEntity<?> updateWatchlistSeriesList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.setWatchListSeries(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);

        }

    }

    @PutMapping("/delete/series/history/{id}")
    public ResponseEntity<?> deleteHistorySeriesList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.deleteHistorySeries(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/movie/history/{id}")
    public ResponseEntity<?> deleteHistoryMovieList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.deleteHistoryMovie(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/movie/watchlist/{id}")
    public ResponseEntity<?> deleteWatchlistMovieList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.deleteWatchlistMovie(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/series/watchlist/{id}")
    public ResponseEntity<?> deleteWatchlistSeriesList(Principal user, @PathVariable("id") String id){
        User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
        if(userObj.isEnabled()){
            userObj.deleteWatchlistSeries(id);
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(repository.save(userObj), HttpStatus.NOT_FOUND);

        }

    }

}
