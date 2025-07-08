package com.example.MovieApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class MovieClient {
    private final RestClient restClient;

    public MovieClient(RestClient.Builder restClientBuilder, @Value("${api.auth.key}") String key) {
        this.restClient = restClientBuilder.baseUrl("https://api.themoviedb.org/3/").defaultHeader("accept", "application/json").defaultHeader("Authorization", key ).build();
        System.out.println(key);
    }


    public String getMovies() {
        return restClient.get().uri("/discover/movie").retrieve().body(String.class);
    }

    public List<Movie> getMovieByName(@RequestParam String name) {
        return restClient.get().uri(String.format("search/movie?query=%s&include_adult=false&language=en-US&page=1", name)).retrieve().body(Response.class).results();
    }

}
