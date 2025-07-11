package com.example.MovieApp;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MovieClient {
    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(MovieClient.class);
    private final Counter searchCounter;
    private final Timer searchTimer;

    @Autowired
    public MovieClient(RestClient.Builder restClientBuilder, @Value("${api.auth.key}") String key, MeterRegistry meterRegistry) {
        this.restClient = restClientBuilder.baseUrl("https://api.themoviedb.org/3/").defaultHeader("accept", "application/json").defaultHeader("Authorization", key).build();
        this.searchCounter = meterRegistry.counter("search_results");
        this.searchTimer = meterRegistry.timer("search_timer");
    }

    public List<Movie> getMovies() {
        List<Movie> allMovies = new ArrayList<>();

        // Fetch the first 3 pages
        for (int page = 1; page <= 5; page++) {
            int finalPage = page;
            Response response = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/discover/movie")
                            .queryParam("page", finalPage)
                            .build())
                    .retrieve()
                    .body(Response.class);

            if (response != null && response.results() != null) {
                allMovies.addAll(response.results());
            }
        }

        return allMovies;
    }

    public MovieDetails getMovie(@RequestParam String id) {
        return restClient.get().uri(String.format("movie/%s?language=en-US", id)).retrieve().body(MovieDetails.class);
    }

    public List<Movie> getMovieByName(@RequestParam String name) {
        searchCounter.increment();
        return restClient.get().uri(String.format("search/movie?query=%s&include_adult=false&language=en-US&page=1", name)).retrieve().body(Response.class).results();
    }

    public List<Provider> getMovieProvider(@RequestParam int id) {
        var startTime = System.currentTimeMillis();
        var result = restClient.get().uri(String.format("movie/%d/watch/providers", id)).retrieve().body(ProviderResponse.class).results().US().flatrate();
        searchTimer.record(System.currentTimeMillis() - startTime, TimeUnit.MILLISECONDS);
        return result;
    }

    public List<MovieVideo> getMovieVideos(@RequestParam int movieId) {
        return restClient.get().uri(String.format("movie/%d/videos?language=en-US", movieId)).retrieve().body(VideoResponse.class).results();
    }

}
