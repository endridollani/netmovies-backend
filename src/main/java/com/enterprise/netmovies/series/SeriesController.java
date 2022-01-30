package com.enterprise.netmovies.series;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api/v1/series")
@AllArgsConstructor
public class SeriesController {
	
	@Autowired
    private SeriesService seriesService;
    
    @RequestMapping("api/v1/series/latest")
    public List<Series> getLatestSeries() {
        return seriesService.getLatestSeries();
    }

    @RequestMapping("api/v1/series/trending")
    public List<Series> getTrendingSeries() {
        return seriesService.getTrendingSeries();
    }
    
    @RequestMapping("api/v1/series/popular")
    public List<Series> getPopularSeries() {
        return seriesService.getPopularSeries();
    }
    
    @RequestMapping("api/v1/series/history/{userId}")
    public List<Series> getSeriesHistory(Long userId) {
        return seriesService.getSeriesHistory(userId);
    }
    
    @RequestMapping("api/v1/series/watchlist/{userId}")
    public List<Series> getSeriesWatchlist(Long userId) {
        return seriesService.getSeriesWatchlist(userId);
    }
    
    @RequestMapping("api/v1/series/find/{query}")
    public List<Series> findSeries(String query) {
        return seriesService.findSeries(query);
    }
    
    @RequestMapping("api/v1/series/details/{SeriesId}")
    public Series getSeriesDetails(String SeriesId) {
    	return seriesService.getSeriesDetails(SeriesId);
    }
    
    @RequestMapping("api/v1/series/similar/{SeriesId}")
    public List<Series> getSimilarSeries(String SeriesId) {
        return seriesService.getSimilarSeries(SeriesId);
    }
    
    
    

    
    
    
}
