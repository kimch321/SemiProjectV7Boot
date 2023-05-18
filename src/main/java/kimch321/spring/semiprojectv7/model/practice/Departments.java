package kimch321.spring.semiprojectv7.model.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DEPARTMENTS")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptid;
    private String dname;
    private Long mrgid;
    private Long locid;
}
