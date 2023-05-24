package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Pds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pdsdao")
public class PdsDAOImpl implements PdsDAO {

    @Autowired
    PdsRepository pdsRepository;

    @Override
    public int insertPds(Pds pds) {
        // 제목,작성자,본문을 pds테이블에 저장한 뒤
        // 저장시 생성된 pno를 리턴함 - pdsattach 저장시 사용
        return Math.toIntExact(pdsRepository.save(pds).getPno());
    }
}