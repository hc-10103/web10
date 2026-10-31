package org.example.jpa_project.service;

import org.apache.coyote.Response;
import org.example.jpa_project.dto.MovieRequest;
import org.example.jpa_project.dto.MovieResponse;
import org.example.jpa_project.entity.Movie;
import org.example.jpa_project.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.example.jpa_project.dto.MovieResponse.from;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResponse> findAll() {
        return movieRepository.findAll().stream().map(MovieResponse::from).toList();
    }

    public MovieResponse findById(Long id) {
        return from(movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Movie not Found" + id)));
    }

    public MovieResponse create(MovieRequest movieRequest) {
        Movie saved = movieRepository.save(new Movie(movieRequest));
        return from(saved);
    }

    public MovieResponse update(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Movie not Found " + id));

        movie.update(movieRequest);
        return from(movieRepository.save(movie));
    }

    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not Found" + id);
        }
        movieRepository.deleteById(id);
    }


}
