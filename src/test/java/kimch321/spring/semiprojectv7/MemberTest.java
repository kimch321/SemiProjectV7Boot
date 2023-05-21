package kimch321.spring.semiprojectv7;

import kimch321.spring.semiprojectv7.model.Member;
import kimch321.spring.semiprojectv7.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("showAll")
    public void findZipByDong() {
        List<Member> mbs = memberRepository.findAll();

        for(Member mb: mbs)
            System.out.println(mb);
    }

    @Test
    @DisplayName("member save")
    public void saveMember() {
        Member m = new Member();

        memberRepository.save(m);
    }

    @Test
    @DisplayName("member update")
    public void updateMember() {
        Member m = new Member(4L, "987xyz", "123456","1234567","987xyz","123abc","456-123","서울시 구로동","더조은","987xyz@abc123.co.kr","123-4567",null);

        memberRepository.save(m);
    }

    @Test
    @DisplayName("member delete")
    public void deleteMember() {
        Member m = new Member();
        m.setMbno(6L);

        memberRepository.delete(m);
    }

    @Test
    @DisplayName("member login")
    public void loginMember() {
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("abc123");

        assertNotNull(memberRepository.countByUseridAndPasswd(m.getUserid(),m.getPasswd()));
    }
}
