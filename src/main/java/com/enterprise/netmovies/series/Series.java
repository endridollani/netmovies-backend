package com.enterprise.netmovies.series;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Series {
	@Id
	@Indexed(unique = true)
    private String id;
    private String name;
    private String overview;
    private List<Genre> genres;
    private List<Season> seasons;
    private Double vote_average;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    

	public String getTmdb_id() {
		return id;
	}

	public String getTitle() {
		return name;
	}

	public String getDescription() {
		return overview;
	}

	public List<Genre> getGenres() {
		return genres;
	}
	
	public List<Season> getSeasons() {
		return seasons;
	}
	
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons; 
	}

	public Double getRating() {
		return vote_average;
	}

	public void setRating(Double rating) {
		this.vote_average = rating;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public String getRelease_date() {
		return release_date;
	}

    
    
}
