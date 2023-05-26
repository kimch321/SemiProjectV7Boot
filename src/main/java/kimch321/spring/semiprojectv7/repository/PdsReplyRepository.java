package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.PdsReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PdsReplyRepository extends JpaRepository<PdsReply, Long> {

    @Query("from PdsReply where pno = :pno order by refno, regdate asc ")
    List<PdsReply> findByPnoOrderByRefnoAscRegdateAsc(int pno);
}
