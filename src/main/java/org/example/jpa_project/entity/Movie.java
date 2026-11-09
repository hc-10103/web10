package org.example.jpa_project.entity;

import jakarta.persistence.*;
import org.example.jpa_project.dto.MovieRequest;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
/* Q1
@Entity는 해당 클래스를 JPA가 관리하는 엔티티로 지정하는 어노테이션이다.
@Id는 해당 변수를 기본 키로 설정하는 어노테이션이며, 이 기본 키를 이용해 데이터를 식별한다.
@GeneratedValue는 기본 키 값을 자동으로 생성하게 만드는 어노테이션이다.
*/
@EntityListeners(AuditingEntityListener.class)
@Table(name = "movie")
/* Q2
ORM 기능을 통해 자바와 DB가 연결된다. Entity 클래스가 DB의 테이블로, 필드가 Column으로, 인스턴스가 Row로 , @id 필드가
테이블의 기본 키와 맵핑된다.
@Table을 통해 연결할 테이블 이름을, @Column을 통해 연결할 칼럼 이름을 지정할 수 있다.
*/

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
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

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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
