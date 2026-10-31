package org.example.jpa_project.dto;

import org.example.jpa_project.entity.Movie;

public record MovieResponse(Long id, String title, String director, String releaseDate, Integer screenTime,
                            Float rating) {

    public static MovieResponse from(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getReleaseDate(),
                movie.getScreenTime(), movie.getRating());
    }

}
