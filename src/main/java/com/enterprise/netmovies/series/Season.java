package com.enterprise.netmovies.series;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Season {
	@Id
	@Indexed(unique = true)
    private String id;
    private String name;
    private String overview;
    private int season_number;
    private List<Episode> episodes;
    private String poster_path;
    private String backdrop_path;
    private String air_date;
    
    
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public int getSeason_number() {
		return season_number;
	}
	
	public List<Episode> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
	public String getPoster_path() {
		return poster_path;
	}
	
	public String getBackdrop_path() {
		return backdrop_path;
	}
	
	public String getAir_date() {
		return air_date;
	}
	
    
    
}