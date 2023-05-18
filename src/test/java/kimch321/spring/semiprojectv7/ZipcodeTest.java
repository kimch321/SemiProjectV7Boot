package kimch321.spring.semiprojectv7;

import kimch321.spring.semiprojectv7.model.Zipcode;
import kimch321.spring.semiprojectv7.repository.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
