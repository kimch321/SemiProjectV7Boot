package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Member;
import kimch321.spring.semiprojectv7.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public int selectLogin(Member m) {
        int isLogin = -1;

        if(memberRepository.findByUseridAndPasswd(m.getUserid(), m.getPasswd()) != null)
            isLogin = 1;

        return isLogin;
    }
}
