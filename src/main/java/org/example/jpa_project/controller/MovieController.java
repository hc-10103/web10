package org.example.jpa_project.controller;

import jakarta.validation.Valid;
import org.example.jpa_project.dto.MovieRequest;
import org.example.jpa_project.dto.MovieResponse;
import org.example.jpa_project.entity.Movie;
import org.example.jpa_project.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService, MovieService movieService1) {
        this.movieService = movieService1;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> create(@Valid @RequestBody MovieRequest request) {
        MovieResponse movieResponse = movieService.create(request);
        return ResponseEntity.created(URI.create("api/movies/" + movieResponse.id())).body(movieResponse);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<MovieResponse> movieResponseList = movieService.findAll();
        return ResponseEntity.ok(movieResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        MovieResponse movieResponse = movieService.findById(id);
        return ResponseEntity.ok(movieResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@Valid @RequestBody MovieRequest request,
                                                @PathVariable Long id) {
        MovieResponse response = movieService.update(id,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }







}
