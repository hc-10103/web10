package org.example.jpa_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MovieRequest(@NotBlank @Size(max = 200)   String title,
                           @NotBlank @Size(max = 100)   String director,
                           @NotBlank @Size(max = 100)   String releaseDate,
                           @NotNull @Positive           Integer screenTime,
                                                        Float rating) {

}
