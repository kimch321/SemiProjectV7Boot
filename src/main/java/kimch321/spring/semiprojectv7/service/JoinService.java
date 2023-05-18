package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Member;

public interface JoinService {

    String findZipcode(String dong);
    boolean newMember(Member m);
    int checkUserid(String uid);
    boolean loginMember(Member m);

}
