package kimch321.spring.semiprojectv7.model.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEES")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long empid;
    @Column(name = "FIRST_NAME")
    private String fname;
    @Column(name = "LAST_NAME")
    private String lname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phone;
    @Column(name = "HIRE_DATE")
    private Date hdate;
    @Column(name = "JOB_ID")
    private String jobid;
    @Column(name = "SALARY")
    private Integer sal;
    @Column(name = "COMMISSION_PCT", precision = 5, scale = 2, nullable = true)
    private BigDecimal comm;
    @Column(name = "MANAGER_ID")
    private Integer mgrid;
    @Column(name = "DEPARTMENT_ID")
    private Long deptid;

    /*@ManyToOne // 테이블 연관 관계 = 다 : 1
    @JoinColumn(name = "DEPARTMENT_ID", insertable = false, updatable = false)
    //department 테이블의 id 컬럼과 조인
    private Departments department;*/
}
