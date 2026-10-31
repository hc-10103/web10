package org.example.jpa_project.dto;

public record MovieRequest(String title,
                           String director,
                           String releaseDate,
                           Integer screenTime,
                           Float rating) {

}
