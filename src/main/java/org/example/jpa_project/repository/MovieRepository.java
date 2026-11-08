package org.example.jpa_project.repository;

import org.example.jpa_project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/* Q3
JpaRepository<Movie, Long> 에서 Movie는 Entity이다. 즉, JPA가 관리할 Entity 클래스를 의미하고, Long은 Id로,
기본 키의 타입을 의미한다.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
