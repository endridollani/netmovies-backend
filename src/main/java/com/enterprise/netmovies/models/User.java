package com.enterprise.netmovies.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "AUTH_USER_DETAILS")
public class User implements UserDetails {


    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Collection<String> watchListMovies = new ArrayList<>();
    private Collection<String> watchListSeries = new ArrayList<>();
    private Collection<String> historyMovies = new ArrayList<>();
    private Collection<String> historySeries = new ArrayList<>();

    public Collection<String> getWatchListMovies() {
        return watchListMovies;
    }

    public void setWatchListMovies(String addedMovie) {
        this.watchListMovies.add(addedMovie);
    }

    public void deleteWatchlistMovie(String movieId) {
        watchListMovies.remove(movieId);
    }

    public Collection<String> getWatchListSeries() {
        return watchListSeries;
    }

    public void setWatchListSeries(String  addedSerie) {
        this.watchListSeries.add(addedSerie);
    }

    public void deleteWatchlistSeries(String seriesId) {
        watchListSeries.remove(seriesId);
    }

    public Collection<String> getHistoryMovies() {
        return historyMovies;
    }

    public void setHistoryMovies(String movieId) {
        this.historyMovies.add(movieId);
    }

    public void deleteHistoryMovie(String movieId) {
        historyMovies.remove(movieId);
    }

    public Collection<String> getHistorySeries() {
        return historySeries;
    }

    public void setHistorySeries(String serieId) {
        this.historySeries.add(serieId);
    }

    public void deleteHistorySeries(String seriesId) {
        historySeries.remove(seriesId);
    }


    private boolean enabled = true;

    //Mapping Authority document with User document
//    @DocumentReference(collection = "AUTH_AUTHORITY")
    private Collection<Authority> authorities = new ArrayList<>();

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}