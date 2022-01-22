package com.enterprise.netmovies.series;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/series")
@CrossOrigin("*")
@AllArgsConstructor
public class SeriesController {
	
	@Autowired
    private SeriesService seriesService;
    
    @RequestMapping("/latest")
    public List<Series> getLatestSeries() {
        return seriesService.getLatestSeries();
    }

    @RequestMapping("/trending")
    public List<Series> getTrendingSeries() {
        return seriesService.getTrendingSeries();
    }
    
    @RequestMapping("/popular")
    public List<Series> getPopularSeries() {
        return seriesService.getPopularSeries();
    }
    
    @RequestMapping("/history/{userId}")
    public List<Series> getSeriesHistory(Long userId) {
        return seriesService.getSeriesHistory(userId);
    }
    
    @RequestMapping("/watchlist/{userId}")
    public List<Series> getSeriesWatchlist(Long userId) {
        return seriesService.getSeriesWatchlist(userId);
    }
    
    @RequestMapping("/find/{query}")
    public List<Series> findSeries(String query) {
        return seriesService.findSeries(query);
    }
    
    @RequestMapping("/details/{SeriesId}")
    public Series getSeriesDetails(String SeriesId) {
    	return seriesService.getSeriesDetails(SeriesId);
    }
    
    @RequestMapping("/similar/{SeriesId}")
    public List<Series> getSimilarSeries(String SeriesId) {
        return seriesService.getSimilarSeries(SeriesId);
    }
    
    
    

    
    
    
}
