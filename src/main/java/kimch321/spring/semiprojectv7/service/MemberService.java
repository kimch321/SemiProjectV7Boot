package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {
    boolean checkLogin(Member m, HttpSession sess);

}
