package com.example.MovieApp;

import java.util.List;

public record TVSerie(Boolean adult, List<Integer> genre_ids, int id, List<String> origin_country, String name, String overview, Long popularity, String poster_path, String first_air_date, Long vote_average, int vote_count) {
}
