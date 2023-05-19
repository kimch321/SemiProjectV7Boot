package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Member;
import kimch321.spring.semiprojectv7.model.Zipcode;
import kimch321.spring.semiprojectv7.repository.MemberRepository;
import kimch321.spring.semiprojectv7.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jndao")
public class JoinDAOImpl implements JoinDAO{

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Zipcode> selectZipcode(String dong) {
        return zipcodeRepository.findZipcodeByDong(dong);
    }

    @Override
    public int insertMember(Member m) {
        int isSaved = -1;

        m = memberRepository.save(m);
        if(m != null) isSaved = Math.toIntExact(m.getMbno());

        return isSaved;
    }

    @Override
    public int selectOneUserid(String uid) {
        return 0;
    }

    @Override
    public int selectOneMember(Member m) {
        return 0;
    }
}
