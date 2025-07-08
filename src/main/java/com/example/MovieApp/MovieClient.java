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


    public String getMovies() {

        return restClient.get().uri("/discover/movie").retrieve().body(String.class);
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

}
