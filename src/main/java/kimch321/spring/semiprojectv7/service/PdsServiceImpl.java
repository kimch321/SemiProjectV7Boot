package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.dao.PdsDAO;
import kimch321.spring.semiprojectv7.model.Pds;
import kimch321.spring.semiprojectv7.utils.PdsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("pdssrv")
public class PdsServiceImpl implements PdsService {

    @Autowired
    PdsDAO pdsdao;
    @Autowired
    PdsUtils pdsUtils;

    @Override
    public int newPds(Pds pds) {
        pds.setUuid(pdsUtils.makeUUID());
        return pdsdao.insertPds(pds);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {
        return true;
    }
}