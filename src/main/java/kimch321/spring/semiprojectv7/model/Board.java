package kimch321.spring.semiprojectv7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BOARD")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bno;
    private String title;
    private String userid;

    @Column(insertable = false, updatable = false)
    private String thumbs;
    @Column(insertable = false, updatable = false)
    private String views;

    private String content;

    @CreatedDate
    @Column(insertable = false, updatable = false)
    private String regdate;
}
