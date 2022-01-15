package com.enterprise.netmovies;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class MovieService {
	
	private String baseURL = "https://api.themoviedb.org/3/";
	@Value("${moviedb.apiKey}")
	private String apiKey;
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
    private MovieRepository movieRepository;
	@Autowired
    private StudentRepository studentRepository;


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

	public List<Movie> getMovieHistory(String userId) {
		Optional<Student> student = studentRepository.findById(userId); 
		//Need to extract the movie id's in history then requesting movierepository to match those ids
		//Then return Movie List
		return null;
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

	public List<Movie> getMovieWatchlist(String userId) {
		Optional<Student> student = studentRepository.findById(userId); 
		//Need to extract the movie id's in watchlist then requesting movierepository to match those ids
		//Then return Movie List
		return null;
	}
}
