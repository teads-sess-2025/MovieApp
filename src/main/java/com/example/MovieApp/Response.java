package com.example.MovieApp;

import java.util.List;

public record Response(
        int page,
        List<Movie> results,
        int totalPages,
        int totalResults
) {
}
