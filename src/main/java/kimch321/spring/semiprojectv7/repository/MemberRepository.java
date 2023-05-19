package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository
        extends JpaRepository<Member, Long> {

    List<Member> findAll();

}
