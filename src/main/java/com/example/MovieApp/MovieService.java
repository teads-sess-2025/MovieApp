package com.example.MovieApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ObjectMapper objectMapper;

    public MovieService(MovieRepository movieRepository, ObjectMapper objectMapper) {
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
    }
    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }


    @Transactional
    public MovieEntity saveMovie(MovieDetails details, Integer playlistId) {
        String genresJson = toJson(details.genres());
        String companiesJson = toJson(details.production_companies());
        String originCountryJson = toJson(details.origin_country());

        MovieEntity movie = new MovieEntity(
                details.id(),
                details.title(),
                details.original_title(),
                details.tagline(),
                details.overview(),
                details.release_date(),
                details.poster_path(),
                details.backdrop_path(),
                details.status(),
                details.adult(),
                details.budget(),
                details.revenue(),
                details.vote_count(),
                details.vote_average(),
                playlistId,
                originCountryJson,
                genresJson,
                companiesJson

        );

        return movieRepository.save(movie);
    }
}
