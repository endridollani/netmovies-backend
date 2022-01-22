package com.enterprise.netmovies.movie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;
import com.enterprise.netmovies.user.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class MovieService {
    public MovieService(){}
    private String baseURL = "https://api.themoviedb.org/3/";
    @Value("${moviedb.apiKey}")
    private String apiKey;
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private UserRepository userRepository;


    public List<Movie> getLatestMovies() {
        String requestURL = baseURL + "movie/latest/" + "?api_key=" + apiKey + "&language=en-US";
        Movie[] result = restTemplate.getForObject(requestURL, Movie[].class);
        List<Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<Movie> getTrendingMovies() {
        String requestURL = baseURL + "trending/movie/week/" + "?api_key=" + apiKey + "&language=en-US";
        Movie[] result = restTemplate.getForObject(requestURL, Movie[].class);
        List<Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<Movie> getPopularMovies() {
        String requestURL = baseURL + "movie/popular" + "?api_key=" + apiKey + "&language=en-US";
        Movie[] result = restTemplate.getForObject(requestURL, Movie[].class);
        List<Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<Movie> getMovieHistory(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        List<Movie> movieList = new ArrayList<Movie>();

        if(!user.isEmpty()) {
            User usr = user.get();

            List<Movie> movieHistory_ids = usr.getMovieHistory();
            for (int i = 0 ; i < movieHistory_ids.size(); i++) {
                Movie movie = getMovieDetails(movieHistory_ids.get(i).getTmdb_id());
                movieList.add(movie);
            }
        }


        return movieList;
    }

    public List<Movie> getSimilarMovies(String movieId) {
        String requestURL = baseURL + "movie/" + movieId + "/similar?api_key=" + apiKey + "&language=en-US";
        Movie[] result = restTemplate.getForObject(requestURL, Movie[].class);
        List<Movie> movies = Arrays.asList(result);
        return movies;
    }

    public Movie getMovieDetails(String movieId) {
        String requestURL = baseURL + "movie/" + movieId + "?api_key=" + apiKey + "&language=en-US";
        Movie movie = restTemplate.getForObject(requestURL, Movie.class);
        return movie;
    }

    public List<Movie> findMovies(String query) {
        String requestURL = baseURL + "search/movie" + "?api_key=" + apiKey + "&language=en-US&query=" + query;
        Movie[] result = restTemplate.getForObject(requestURL, Movie[].class);
        List<Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<Movie> getMovieWatchlist(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        List<Movie> movieList = new ArrayList<Movie>();

        if(!user.isEmpty()) {
            User usr = user.get();

            List<Movie> movieWatchlist_ids = usr.getMovieWatchlist();
            for (int i = 0 ; i < movieWatchlist_ids.size(); i++) {
                Movie movie = getMovieDetails(movieWatchlist_ids.get(i).getTmdb_id());
                movieList.add(movie);
            }
        }


        return movieList;
    }
}
