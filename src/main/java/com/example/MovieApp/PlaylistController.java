package com.example.MovieApp;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "*") // Allow frontend requests
public class PlaylistController {
    private final PlaylistRepository playlistRepository;
    private final MovieRepository movieRepository;

    public PlaylistController(PlaylistRepository playlistRepository, MovieRepository movieRepository) {
        this.playlistRepository = playlistRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<PlaylistEntity> getPlaylistsForUser() {
        int userId = 1; // hardcoded for now
        return playlistRepository.findByUserId(userId);
    }

    @PostMapping
    public PlaylistEntity createPlaylist(@RequestBody PlaylistEntity playlist) {
        playlist.setUserId(1); // hardcoded user id
        return playlistRepository.save(playlist);
    }

    @GetMapping("/{id}")
    public PlaylistEntity getPlaylistById(@PathVariable int id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/movies")
    public List<MovieEntity> getMoviesForPlaylist(@PathVariable int id) {
        return movieRepository.findByPlaylistId(id);
    }
}
