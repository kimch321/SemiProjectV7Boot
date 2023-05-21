package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Zipcode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {

public interface ZipcodeRepository extends PagingAndSortingRepository<Zipcode, Long> {

    @Query("from Zipcode where dong like %:dong%")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);

    // 전체 조회 중 페이징
    Page<Zipcode> findAll(Pageable pageable);

    // 검색 중 페이징
    Page<Zipcode> findByDongLike(String dong, Pageable pageable);


}
