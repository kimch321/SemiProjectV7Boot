package kimch321.spring.semiprojectv7.practice;

import kimch321.spring.semiprojectv7.model.practice.Employees;
import kimch321.spring.semiprojectv7.repository.practice.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("employee")
    public void findAll(){
        List<Employees> emps = employeeRepository.findAll();

        for(Employees emp: emps)
            System.out.println(emp);
    }

    @Test
    @DisplayName("employee")
    public void findPartial(){
        List<Object[]> emps = employeeRepository.findEmployeesPartialData();

        for(Object[] emp: emps)
            System.out.println(emp[0] + "/" + emp[1]);
    }

    @Test
    @DisplayName("employee")
    public void findJobId() {
        List<Employees> emps = employeeRepository.findEmployeesByJobid("IT_PROG");

        for(Employees emp: emps)
            System.out.println(emp);
    }

    @Test
    @DisplayName("employee")
    public void findSal() {
        List<Employees> emps = employeeRepository.findEmployeesBySalGreaterThanEqual(20000);

        for(Employees emp: emps)
            System.out.println(emp);
    }

    @Test
    @DisplayName("employee")
    public void findOderBy() {
        List<Employees> emps = employeeRepository.findAllByOrderByDeptidDesc();

        for(Employees emp: emps)
            System.out.println(emp);
    }

    @Test
    @DisplayName("employee")
    public void countJobId() {
        int cnt = employeeRepository.countDistinctByJobid();

        assertEquals(19, cnt);
    }

    @Test
    @DisplayName("grouping1")
    public void findEmployees1() {
        List<Object[]> emps = employeeRepository.findEmployees2();

        for(Object[] emp: emps)
            System.out.println(emp[0] + "/" + emp[1] + "/" + emp[2] + "/" + emp[3] + "/" + emp[4]);
    }

    @Test
    @DisplayName("grouping2")
    public void findEmployees2() {
        List<Object[]> emps = employeeRepository.findEmployees3();

        for(Object[] emp: emps)
            System.out.println(emp[0] + "/" + emp[1]);
    }

    @Test
    @DisplayName("grouping3")
    public void findEmployees3() {
        List<Object[]> emps = employeeRepository.findEmployees4();

        for(Object[] emp: emps)
            System.out.println(emp[0] + "/" + emp[1] + "/" + emp[2]);
    }
}
