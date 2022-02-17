package com.enterprise.netmovies.responses;


import java.util.Collection;

public class UserInfo {

    private String firstName;
    private String lastName;
    private String userName;
    private Collection<String> watchlistSeries;
    private Collection<String> watchlistMovies;
    private Collection<String> historyMovies;
    private Collection<String> historySeries;
    private Object roles;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getRoles() {
        return roles;
    }

    public void setRoles(Object roles) {
        this.roles = roles;
    }

    public Collection<String> getWatchlistMovies(){
        return this.watchlistMovies;
    }

    public Collection<String> getWatchlistSeries(){
        return this.watchlistSeries;
    }

    public void setWatchlistMovies(Collection<String> watchlistMovies) {
        this.watchlistMovies = watchlistMovies;
    }

    public void setWatchlistSeries(Collection<String> watchlistSeries){
        this.watchlistSeries = watchlistSeries;
    }
}