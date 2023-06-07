package kimch321.spring.semiprojectv7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "GALATTACH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GalAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gano;

    private String fname;
    private String fsize;

    private Integer gno;
}
