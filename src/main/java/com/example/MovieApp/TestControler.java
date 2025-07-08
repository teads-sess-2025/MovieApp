package com.example.MovieApp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class TestControler {
    private final MovieClient movieClient;

    public TestControler(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    @GetMapping
    public String getMovies() {
        return movieClient.getMovies();
    }

    @GetMapping("/find")
    public List<Movie> findMovie(@RequestParam String name) {
        return movieClient.getMovieByName(name);
    }



    @GetMapping("/streaming")
    public List<Provider> streamMovie(@RequestParam int id) {
        return movieClient.getMovieProvider(id);
    }

}
