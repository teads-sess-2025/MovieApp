package com.example.MovieApp;

import java.util.List;

public record VideoResponse(int id, List<MovieVideo> results) {
}
