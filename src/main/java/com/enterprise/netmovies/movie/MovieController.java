package com.enterprise.netmovies.movie;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@AllArgsConstructor
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("api/v1/movies/latest")
    public List<Movie> getLatestMovies() {
        return movieService.getLatestMovies();
    }

    @RequestMapping("api/v1/movies/trending")
    public List<Movie> getTrendingMovies() {
        return movieService.getTrendingMovies();
    }

    @RequestMapping("api/v1/movies/popular")
    public List<Movie> getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @RequestMapping("api/v1/movies/history/{userId}")
    public List<Movie> getMovieHistory(Long userId) {
        return movieService.getMovieHistory(userId);
    }

    @RequestMapping("api/v1/movies/watchlist/{userId}")
    public List<Movie> getMovieWatchlist(Long userId) {
        return movieService.getMovieWatchlist(userId);
    }

    @RequestMapping("api/v1/movies/find/{query}")
    public List<Movie> findMovies(String query) {
        return movieService.findMovies(query);
    }

    @RequestMapping("api/v1/movies/details/{movieId}")
    public Movie getMovieDetails(String movieId) {
        return movieService.getMovieDetails(movieId);
    }

    @RequestMapping("api/v1/movies/similar/{movieId}")
    public List<Movie> getSimilarMovies(String movieId) {
        return movieService.getSimilarMovies(movieId);
    }





}

