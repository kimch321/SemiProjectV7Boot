package kimch321.spring.semiprojectv7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "GALLERY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @NotBlank(message = "제목은 필수항목입니다")
    private String title;
    @NotBlank(message = "작성자는 필수항목입니다")
    private String userid;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime regdate;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private int thumbs;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private int views;
    @NotBlank(message = "본문은 필수항목입니다.")
    private String content;
    private String uuid;

}
