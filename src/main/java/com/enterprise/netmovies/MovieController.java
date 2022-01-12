package com.enterprise.netmovies;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin("*")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService = new MovieService();
    
    @RequestMapping("/latest")
    public List<Movie> getLatestMovies() {
        return movieService.getLatestMovies();
    }

    @RequestMapping("/trending")
    public List<Movie> getTrendingMovies() {
        return movieService.getTrendingMovies();
    }
    
    @RequestMapping("/popular")
    public List<Movie> getPopularMovies() {
        return movieService.getPopularMovies();
    }
    
    @RequestMapping("/history/{userId}")
    public List<Movie> getMovieHistory(String userId) {
        return movieService.getMovieHistory(userId);
    }
    
    @RequestMapping("/watchlist/{userId}")
    public List<Movie> getMovieWatchlist(String userId) {
        return movieService.getMovieWatchlist(userId);
    }
    
    @RequestMapping("/genre/{genre}")
    public List<Movie> getByGenre(String genre) {
        return movieService.getByGenre(genre);
    }
    
    @RequestMapping("/find/{query}")
    public List<Movie> findMovies(String query) {
        return movieService.findMovies(query);
    }
    
    @RequestMapping("/details/{movieId}")
    public List<Movie> getMovieDetails(String movieId) {
        return movieService.getMovieDetails(movieId);
    }
    
    @RequestMapping("/similar/{movieId}")
    public List<Movie> getSimilarMovies(String movieId) {
        return movieService.getSimilarMovies(movieId);
    }
    

    
    
    
}
