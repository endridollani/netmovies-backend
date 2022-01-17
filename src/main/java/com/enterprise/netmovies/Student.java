package com.enterprise.netmovies;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document

public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;
    private List<Movie> movieWatchlist;
    private List<Movie> movieHistory;

    public Student(String firstName,
                   String lastName,
                   String email,
                   List<String> favoriteSubjects,
                   BigDecimal totalSpentInBooks,
                   LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getFavoriteSubjects() {
		return favoriteSubjects;
	}

	public void setFavoriteSubjects(List<String> favoriteSubjects) {
		this.favoriteSubjects = favoriteSubjects;
	}

	public BigDecimal getTotalSpentInBooks() {
		return totalSpentInBooks;
	}

	public void setTotalSpentInBooks(BigDecimal totalSpentInBooks) {
		this.totalSpentInBooks = totalSpentInBooks;
	}

	public LocalDateTime getCreated() {
		return created;
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
    
    


}
