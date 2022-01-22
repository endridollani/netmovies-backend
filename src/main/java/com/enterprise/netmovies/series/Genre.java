package com.enterprise.netmovies.series;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Genre {
	@Id
	@Indexed(unique = true)
    private String id;
    private String name;
    
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}