package org.example.jpa_project.repository;

import org.example.jpa_project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/* Q3
JpaRepository<Movie, Long> 에서 Movie는 Entity이다. 즉, JPA가 관리할 Entity 클래스를 의미하고, Long은 Id로,
기본 키의 타입을 의미한다.
 */

/* Q4
CRUD 5개 이상
1. save(entity)	엔티티 저장 또는 수정
2. findById(id)	ID로 엔티티 한 개 조회
3. findAll()	전체 엔티티 조회
4. deleteById(id)	특정 ID의 데이터 삭제
5. deleteAll()	전체 데이터 삭제
 */

/* Q5
findById가 Optional이어야 찾는 Id에 해당하는 데이터가 존재하지 않을 경우 Null 처리를 할 수 있기 떄문이다.
만약 Optional이 아닐 경우 찾는 데이터가 존재하지 않으면 에러가 터질 수 있다.
 */

/* Q6
기본 제공 메서드는 JPA에서 제공하는 공통 함수이고, Query Method는 개발자가 직접 만드는 함수이다.
제공되는 CRUD 중 findById와 findAll은 존재하지만 예를 들어 영화 제목으로 검색의 CRUD 기능은 존재하지 않는다.
이럴 떄 Query Method를 만듦으로써 개발자가 원하는 쿼리문을 쉽게 작성할 수 있다.
 */

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
