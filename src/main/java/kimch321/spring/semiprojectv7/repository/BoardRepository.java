package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {
    // JpaRepository 에서는 DML은 지원 X
    // 단, Modifying, Transactional등을 추가하면 사용가능

    @Modifying
    @Transactional
    @Query(
            "update Board set views = views + 1 where bno = :bno")
    int countViewBoard(@Param("bno") long bno);

    // @Query("select ceil(count(bno)/25) from Board")
    // int countBoardBy();

    // 제목으로 검색
    Page<Board> findByTitleContains(Pageable paging, String fkey);
    // 제목 + 본문으로 검색
    Page<Board> findByTitleContainsOrContentContains(Pageable paging, String fkey1, String fkey2);
    // 작성자로 검색
    Page<Board> findByUserid(Pageable paging, String fkey);
    // 본문으로 검색
    Page<Board> findByContentContains(Pageable paging, String fkey);

    /*int countByTitleContains(String fkey);
    int countByTitleContainsOrContentContains(String fkey1, String fkey2);
    int countByUserid(String fkey);
    int countByContentContains(String fkey);*/

}
