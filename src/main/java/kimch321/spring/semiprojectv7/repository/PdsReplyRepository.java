package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.PdsReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PdsReplyRepository extends JpaRepository<PdsReply, Long> {

    @Query("from PdsReply where pno = :pno order by refno, regdate asc ")
    List<PdsReply> findByPnoOrderByRefnoAscRegdateAsc(int pno);

    @Transactional
    @Modifying
    @Query("update PdsReply set refno = :rpno where rpno = :rpno")
    void updateRefno(@Param("rpno")int rpno);
}
