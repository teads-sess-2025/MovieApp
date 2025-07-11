package com.example.MovieApp;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "*") // Allow frontend requests
public class PlaylistController {
    private final PlaylistRepository playlistRepository;

    public PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @GetMapping
    public List<PlaylistEntity> getPlaylistsForUser() {
        int userId = 1; // hardcoded for now
        return playlistRepository.findByUserId(userId);
    }
}
