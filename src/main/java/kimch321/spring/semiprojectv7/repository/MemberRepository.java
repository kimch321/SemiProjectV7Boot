package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository
        extends JpaRepository<Member, Long> {
    // 로그인 처리 1
    //Member findByUseridAndPasswd(String userid, String passwd);

    // 로그인 처리 2
    int countByUseridAndPasswd(String userid, String passwd);
}
