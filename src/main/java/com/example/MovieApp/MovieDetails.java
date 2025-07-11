package com.example.MovieApp;
import java.util.List;

record Genre(int id, String name) { }
record ProductionCompany(int id, String name, String logo_path){}

public record MovieDetails(
        Integer id,
        String adult,
        String backdrop_path,
        Integer budget,
        List<Genre> genres,
        List<String> origin_country,
        String original_title,
        String overview,
        String poster_path,
        List<ProductionCompany> production_companies,
        String release_date,
        String revenue,
        String title,
        String tagline,
        String status,
        int vote_count,
        Long vote_average
        ) {
}
