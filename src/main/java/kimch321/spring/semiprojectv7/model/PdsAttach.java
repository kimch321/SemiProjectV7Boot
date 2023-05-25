package kimch321.spring.semiprojectv7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PDSATTACH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PdsAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pano;

    private String fname;
    private String ftype;
    private String fsize;

    @Column(insertable = false, updatable = false)
    private int fdown;
    private Integer pno;
}
