package org.example.jpa_project.entity;

import jakarta.persistence.*;
import org.example.jpa_project.dto.MovieRequest;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(nullable = false, length = 100)
    private String releaseDate;

    @Column(nullable = false, length = 100)
    private Integer screenTime;

    @Column(nullable = true)
    private Float rating;

    protected Movie() {}

    public Movie(MovieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.releaseDate = request.releaseDate();
        this.screenTime = request.screenTime();
        this.rating = request.rating();
    }

    public void update(MovieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.releaseDate = request.releaseDate();
        this.screenTime = request.screenTime();
        this.rating = request.rating();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getScreenTime() {
        return screenTime;
    }

    public void setScreenTime(Integer screenTime) {
        this.screenTime = screenTime;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
