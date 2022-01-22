package com.enterprise.netmovies.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.enterprise.netmovies.movie.Movie;
import com.enterprise.netmovies.series.Series;

@Document(collection = "User")

public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;



    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    private List<Movie> movieWatchlist;
    private List<Movie> movieHistory;
    private List<Series> seriesWatchlist;
    private List<Series> seriesHistory;

    public User(){

    }

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Movie> getMovieWatchlist() {
		return movieWatchlist;
	}

	public void setMovieWatchlist(List<Movie> movieWatchlist) {
		this.movieWatchlist = movieWatchlist;
	}

	public List<Movie> getMovieHistory() {
		return movieHistory;
	}

	public void setMovieHistory(List<Movie> movieHistory) {
		this.movieHistory = movieHistory;
	}
    
	public List<Series> getSeriesWatchlist() {
		return seriesWatchlist;
	}

	public void setSeriesWatchlist(List<Series> seriesWatchlist) {
		this.seriesWatchlist = seriesWatchlist;
	}

	public List<Series> getSeriesHistory() {
		return seriesHistory;
	}

	public void setSeriesHistory(List<Series> seriesHistory) {
		this.seriesHistory = seriesHistory;
	}

}
