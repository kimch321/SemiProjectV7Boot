package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Pds;
import org.springframework.web.multipart.MultipartFile;

public interface PdsService {

    int newPds(Pds pds);
    boolean newPdsAttach(MultipartFile attach, int pno);
}
