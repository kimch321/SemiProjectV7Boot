package kimch321.spring.semiprojectv7.dao;


import kimch321.spring.semiprojectv7.model.Pds;
import kimch321.spring.semiprojectv7.model.PdsAttach;
import kimch321.spring.semiprojectv7.model.PdsReply;

import java.util.List;
import java.util.Map;

public interface PdsDAO {

    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);

    Map<String, Object> selectPds(int cpg);

    Pds selectOnePds(int pno);

    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<PdsReply> selectPdsReply(int pno);

    int insertReply(PdsReply reply);
}