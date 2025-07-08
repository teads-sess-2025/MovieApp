package com.example.MovieApp;

import java.util.List;

public record Movie(
        Boolean adult,
        List<Integer> genre_ids,
        int id,
        String original_language,
        String title,
        String overview,
        String poster_path,
        String release_date,
        String vote_average,
        int vote_count
) {
}