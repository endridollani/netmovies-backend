package com.enterprise.netmovies;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Movie {
	@Id
	@Indexed(unique = true)
    private String tmdb_id;
	@Indexed(unique = true)
	private String imdb_id;
    private String title;
    private String description;
    private List<String> genres;
    private Double rating;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    
    public Movie(String tmdb_id, String imdb_id, String title, String description, List<String> genres, Double rating, String poster_path, String backdrop_path, String release_date) {
    	this.tmdb_id = tmdb_id;
    	this.imdb_id = imdb_id;
    	this.title = title;
    	this.description = description;
    	for(String genre : genres) {
    		this.genres.add(genre);
    	}
    	this.rating = rating;
    	this.poster_path = poster_path;
    	this.backdrop_path = backdrop_path;
    	this.release_date = release_date;
    }

	public String getTmdb_id() {
		return tmdb_id;
	}

	public void setTmdb_id(String tmdb_id) {
		this.tmdb_id = tmdb_id;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
    
    
}
