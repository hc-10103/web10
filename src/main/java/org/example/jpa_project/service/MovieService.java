package org.example.jpa_project.service;

import jakarta.transaction.Transactional;
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

    public List<MovieResponse> findByTitle(String title) {
        return  movieRepository.findByTitle(title).stream().map(MovieResponse::from).toList();
    }

    public List<MovieResponse> findByDirectorAndRatingBetween(String director, Float rate1, Float rate2) {
        return movieRepository.findByDirectorAndRatingBetween(director, rate1, rate2)
                .stream().map(MovieResponse::from).toList();
    }

    public List<MovieResponse> findAllByOrderByRatingDesc() {
        return movieRepository.findAllByOrderByRatingDesc().stream().map(MovieResponse::from).toList();
    }


    /* Q7
    create와 update에서 모두 save를 사용하여 데이터를 저장한다. 이미 존재하는 ID라면 update를, 존재하지 않는 ID라면 새롭게 create를
    진행한다.
     */
    public MovieResponse create(MovieRequest movieRequest) {
        Movie saved = movieRepository.save(new Movie(movieRequest));
        return from(saved);
    }

    /* Q8
    @Transactional은 트랜잭션을 관리하는 어노테이션이다. Dirty Checking은 JPA가 영속성을 지닌 엔티티 변경사항을 자동으 감지하여 DB에
    반영하는 기능이다.
    @Transactional이 적용된 메서드에서 Repository를 통해 Entity를 조회하면, 해당 Entity는 영속성 컨텍스트에서 관리된다.
    이후 Entity의 필드 값을 변경하면 JPA가 변경 사항을 감지하고, 트랜잭션 커밋 시 UPDATE SQL을 실행하여 DB에 반영한다.
    따라서 repository.save()를 호출하지 않아도 데이터 수정이 가능하다.
     */
    @Transactional
    public MovieResponse update(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Movie not Found " + id));

        movie.update(movieRequest);
        return from(movie);
    }

    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not Found" + id);
        }
        movieRepository.deleteById(id);
    }


}
