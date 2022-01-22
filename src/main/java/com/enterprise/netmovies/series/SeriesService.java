package com.enterprise.netmovies.series;

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
public class SeriesService {
	
	private String baseURL = "https://api.themoviedb.org/3/";
	@Value("${moviedb.apiKey}")
	private String apiKey;
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
    private UserRepository userRepository;


	public List<Series> getLatestSeries() {
		String requestURL = baseURL + "tv/latest/" + "?api_key=" + apiKey + "&language=en-US";
		Series[] result = restTemplate.getForObject(requestURL, Series[].class);
		List<Series> series = Arrays.asList(result);
		return series;
	}

	public List<Series> getTrendingSeries() {
		String requestURL = baseURL + "trending/tv/week/" + "?api_key=" + apiKey + "&language=en-US";
		Series[] result = restTemplate.getForObject(requestURL, Series[].class);
		List<Series> series = Arrays.asList(result);
		return series;
	}

	public List<Series> getPopularSeries() {
		String requestURL = baseURL + "tv/popular" + "?api_key=" + apiKey + "&language=en-US";
		Series[] result = restTemplate.getForObject(requestURL, Series[].class);
		List<Series> series = Arrays.asList(result);
		return series;
	}

	public List<Series> getSeriesHistory(Long userId) {
		Optional<User> user = userRepository.findById(userId); 
		
		List<Series> seriesList = new ArrayList<Series>();
		
		if(!user.isEmpty()) {
			User usr = user.get();
			
			List<Series> seriesHistory_ids = usr.getSeriesHistory();
			for (int i = 0 ; i < seriesHistory_ids.size(); i++) {
				Series series = getSeriesDetails(seriesHistory_ids.get(i).getTmdb_id());
				seriesList.add(series);
			}
		}
		
		
		return seriesList;
	}

	public List<Series> getSimilarSeries(String seriesId) {
		String requestURL = baseURL + "tv/" + seriesId + "/similar?api_key=" + apiKey + "&language=en-US";
		Series[] result = restTemplate.getForObject(requestURL, Series[].class);
		List<Series> series = Arrays.asList(result);
		return series;
	}

	public Series getSeriesDetails(String seriesId) {
		//default details request doesn't include season & episode details
		//we need to make a 2nd request for those and then appending the seasons to the series object
		String seriesDefaultDetails = baseURL + "tv/" + seriesId + "?api_key=" + apiKey + "&language=en-US";
		Series series = restTemplate.getForObject(seriesDefaultDetails, Series.class);
		
		int season_quantity = series.getSeasons().size();
		if(season_quantity > 0) {

			List<Season> seasonList = new ArrayList<Season>();
			
			for (var i = 0 ; i < season_quantity ; i++) {
				String seasonDetails = baseURL + "tv/" + seriesId + "/season/" + i + "?api_key=" + apiKey + "&language=en-US";
				Season season = restTemplate.getForObject(seasonDetails, Season.class);
				seasonList.add(season);
			}
			
			series.setSeasons(seasonList);
		}
		
		return series;
	}

	public List<Series> findSeries(String query) {
		String requestURL = baseURL + "search/tv" + "?api_key=" + apiKey + "&language=en-US&query=" + query;
		Series[] result = restTemplate.getForObject(requestURL, Series[].class);
		List<Series> series = Arrays.asList(result);
		return series;
	}

	public List<Series> getSeriesWatchlist(Long userId) {
		Optional<User> user = userRepository.findById(userId); 
		
		List<Series> seriesList = new ArrayList<Series>();
		
		if(!user.isEmpty()) {
			User usr = user.get();
			
			List<Series> seriesWatchlist_ids = usr.getSeriesWatchlist();
			for (int i = 0 ; i < seriesWatchlist_ids.size(); i++) {
				Series series = getSeriesDetails(seriesWatchlist_ids.get(i).getTmdb_id());
				seriesList.add(series);
			}
		}
		
		
		return seriesList;
	}
}
