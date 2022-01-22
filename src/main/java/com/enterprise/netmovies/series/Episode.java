package com.enterprise.netmovies.series;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Episode {
	@Id
	@Indexed(unique = true)
    private String id;
    private String name;
    private String overview;
    private int episode_number;
    private String still_path;
    private double vote_average;
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
	
	public int getEpisode_number() {
		return episode_number;
	}
	
	public String getStill_path() {
		return still_path;
	}
	
	public double getVote_average() {
		return vote_average;
	}
	
	public String getAir_date() {
		return air_date;
	}
	
    
    
    
}