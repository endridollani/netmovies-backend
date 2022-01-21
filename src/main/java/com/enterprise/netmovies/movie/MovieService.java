package com.enterprise.netmovies.movie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

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
    private MovieRepository movieRepository;
    @Autowired
    private StudentRepository studentRepository;


    public List<com.enterprise.netmovies.Movie> getLatestMovies() {
        String requestURL = baseURL + "movie/latest/" + "?api_key=" + apiKey + "&language=en-US";
        com.enterprise.netmovies.Movie[] result = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie[].class);
        List<com.enterprise.netmovies.Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<com.enterprise.netmovies.Movie> getTrendingMovies() {
        String requestURL = baseURL + "trending/movie/week/" + "?api_key=" + apiKey + "&language=en-US";
        com.enterprise.netmovies.Movie[] result = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie[].class);
        List<com.enterprise.netmovies.Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<com.enterprise.netmovies.Movie> getPopularMovies() {
        String requestURL = baseURL + "movie/popular" + "?api_key=" + apiKey + "&language=en-US";
        com.enterprise.netmovies.Movie[] result = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie[].class);
        List<com.enterprise.netmovies.Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<com.enterprise.netmovies.Movie> getMovieHistory(String userId) {
        Optional<Student> student = studentRepository.findById(userId);

        List<com.enterprise.netmovies.Movie> movieList = new ArrayList<com.enterprise.netmovies.Movie>();

        if(!student.isEmpty()) {
            Student st = student.get();

            List<com.enterprise.netmovies.Movie> movieHistory_ids = st.getMovieHistory();
            for (int i = 0 ; i < movieHistory_ids.size(); i++) {
                com.enterprise.netmovies.Movie movie = getMovieDetails(movieHistory_ids.get(i).getTmdb_id());
                movieList.add(movie);
            }
        }


        return movieList;
    }

    public List<com.enterprise.netmovies.Movie> getSimilarMovies(String movieId) {
        String requestURL = baseURL + "movie/" + movieId + "/similar?api_key=" + apiKey + "&language=en-US";
        com.enterprise.netmovies.Movie[] result = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie[].class);
        List<com.enterprise.netmovies.Movie> movies = Arrays.asList(result);
        return movies;
    }

    public com.enterprise.netmovies.Movie getMovieDetails(String movieId) {
        String requestURL = baseURL + "movie/" + movieId + "?api_key=" + apiKey + "&language=en-US";
        com.enterprise.netmovies.Movie movie = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie.class);
        return movie;
    }

    public List<com.enterprise.netmovies.Movie> findMovies(String query) {
        String requestURL = baseURL + "search/movie" + "?api_key=" + apiKey + "&language=en-US&query=" + query;
        com.enterprise.netmovies.Movie[] result = restTemplate.getForObject(requestURL, com.enterprise.netmovies.Movie[].class);
        List<com.enterprise.netmovies.Movie> movies = Arrays.asList(result);
        return movies;
    }

    public List<com.enterprise.netmovies.Movie> getMovieWatchlist(String userId) {
        Optional<Student> student = studentRepository.findById(userId);

        List<com.enterprise.netmovies.Movie> movieList = new ArrayList<com.enterprise.netmovies.Movie>();

        if(!student.isEmpty()) {
            Student st = student.get();

            List<com.enterprise.netmovies.Movie> movieWatchlist_ids = st.getMovieWatchlist();
            for (int i = 0 ; i < movieWatchlist_ids.size(); i++) {
                Movie movie = getMovieDetails(movieWatchlist_ids.get(i).getTmdb_id());
                movieList.add(movie);
            }
        }


        return movieList;
    }
}
