package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZipcodeRepository
        extends JpaRepository<Zipcode, Long> {
    // 메서드 쿼리: find엔티티명All, find엔티티명By컬럼명
    @Query("from Zipcode where dong like %:dong%")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);


}
