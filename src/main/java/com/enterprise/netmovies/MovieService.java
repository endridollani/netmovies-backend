package com.enterprise.netmovies;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class MovieService {
	@Autowired
    private MovieRepository movieRepository;


	public List<Movie> getLatestMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getTrendingMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getPopularMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getMovieHistory(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getSimilarMovies(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getMovieDetails(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> findMovies(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getMovieWatchlist(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
