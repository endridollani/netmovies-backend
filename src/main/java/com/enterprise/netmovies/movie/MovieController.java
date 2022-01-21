package com.enterprise.netmovies.movie;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("api/v1/movies/latest")
    public List<com.enterprise.netmovies.Movie> getLatestMovies() {
        return movieService.getLatestMovies();
    }

    @RequestMapping("api/v1/movies/trending")
    public List<com.enterprise.netmovies.Movie> getTrendingMovies() {
        return movieService.getTrendingMovies();
    }

    @RequestMapping("api/v1/movies/popular")
    public List<com.enterprise.netmovies.Movie> getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @RequestMapping("api/v1/movies/history/{userId}")
    public List<com.enterprise.netmovies.Movie> getMovieHistory(String userId) {
        return movieService.getMovieHistory(userId);
    }

    @RequestMapping("api/v1/movies/watchlist/{userId}")
    public List<com.enterprise.netmovies.Movie> getMovieWatchlist(String userId) {
        return movieService.getMovieWatchlist(userId);
    }

    @RequestMapping("api/v1/movies/find/{query}")
    public List<com.enterprise.netmovies.Movie> findMovies(String query) {
        return movieService.findMovies(query);
    }

    @RequestMapping("api/v1/movies/details/{movieId}")
    public com.enterprise.netmovies.Movie getMovieDetails(String movieId) {
        return movieService.getMovieDetails(movieId);
    }

    @RequestMapping("api/v1/movies/similar/{movieId}")
    public List<Movie> getSimilarMovies(String movieId) {
        return movieService.getSimilarMovies(movieId);
    }





}

