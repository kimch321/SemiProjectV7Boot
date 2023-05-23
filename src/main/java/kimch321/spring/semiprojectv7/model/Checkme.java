package kimch321.spring.semiprojectv7.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Checkme {
    @NotBlank(message = "이름은 반드시 입력하셔야 합니다!!")
    private String name;

    @NotBlank(message = "주민번호는 반드시 입력하셔야 합니다!!")
    private String jumin1;

    @NotBlank(message = "주민번호는 반드시 입력하셔야 합니다!!")
    private String jumin2;
}
