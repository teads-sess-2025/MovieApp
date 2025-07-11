package com.example.MovieApp;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // allows all origins
@RestController
@RequestMapping("/api")
public class TestControler {
    private final MovieClient movieClient;
    private final MovieService movieService;

    public TestControler(MovieClient movieClient, MovieService movieService) {
        this.movieClient = movieClient;
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieClient.getMovies();
    }

    @GetMapping("/movies/n/{name}")
    public List<Movie> findMovie(@PathVariable String name) {
        return movieClient.getMovieByName(name);
    }

    @GetMapping("/movies/{id}")
    public MovieDetails getMovie(@PathVariable String id) {
        return movieClient.getMovie(id);
    }

    @GetMapping("/movies/{id}/streaming")
    public List<Provider> streamMovie(@PathVariable int id) {
        return movieClient.getMovieProvider(id);
    }

    @GetMapping("movies/{id}/videos")
    public List<MovieVideo> getMovieVideos(@PathVariable int id) {
        return movieClient.getMovieVideos(id);
    }
    @PostMapping("/movies/save/{id}")
    public MovieEntity saveMovie(@PathVariable Integer id,
                                 @RequestParam(required = false) Integer i) {
        MovieDetails details = movieClient.getMovie(id.toString());
        return movieService.saveMovie(details, i);
    }
}
