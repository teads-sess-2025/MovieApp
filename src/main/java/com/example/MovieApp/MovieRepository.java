package com.example.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
        List<MovieEntity> findByPlaylistId(Integer playlistId);
}
