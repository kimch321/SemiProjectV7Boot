package kimch321.spring.semiprojectv7;

import kimch321.spring.semiprojectv7.model.Zipcode;
import kimch321.spring.semiprojectv7.repository.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class ZipcodeTest {

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Test
    @DisplayName("zipcode")
    public void findZipByDong() {
        List<Zipcode> addrs =
                zipcodeRepository.findZipcodeByDong("개포");

        for(Zipcode addr: addrs)
            System.out.println(addr);
    }

    @Test
    @DisplayName("zipcode page1")
    public void pageZipcode() {

        Pageable pageable = PageRequest.of(0, 15);  // 1페이지
        Page<Zipcode> page = zipcodeRepository.findAll(pageable);
        List<Zipcode> zips = page.getContent();

        System.out.println(zips);
    }

    @Test
    @DisplayName("zipcode page2")
    public void page2Zipcode() {
        String dong = "%" + "구로" + "%";
        Pageable pageable = PageRequest.of(0, 15);  // 1페이지
        Page<Zipcode> page = zipcodeRepository.findByDongLike(dong, pageable);
        List<Zipcode> zips = page.getContent();

        System.out.println(zips);
    }

}
