package kimch321.spring.semiprojectv7.repository.practice;

import kimch321.spring.semiprojectv7.model.Zipcode;
import kimch321.spring.semiprojectv7.model.practice.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    // 메서드 쿼리: find엔티티명All, find엔티티명By컬럼명
    // Spring Data JPA는 메서드 이름 규칙을 따를 경우 쿼리 메서드를 자동으로 생성해준다. 이를 Query Creation이라고도 한다.
    // 하지만 복잡한 쿼리를 작성할 경우 @Query 어노테이션을 사용하여 직접 쿼리를 작성하는 것이 효율적일 수도 있다.

    // 모든 컬럼 조회 find엔티티명All
    @Query("from Employees")
    List<Employees> findAll();

    // 부분 조회는 이름규칙 없음.
    @Query("SELECT e.fname, e.sal FROM Employees e")
    List<Object[]> findEmployeesPartialData();

    /*@Query("from Employees where jobid = :jobid")*/
    List<Employees> findEmployeesByJobid(String jobid);

    // 매개변수에 20000을 입력. 메서드 이름 규칙만으로 매개변수 없이 동일한 결과를 얻을 수 없다.
    /*@Query("from Employees where sal >= 20000")*/
    List<Employees> findEmployeesBySalGreaterThanEqual(Integer sal);

    /*@Query("from Employees order by deptid desc ")*/
    List<Employees> findAllByOrderByDeptidDesc();

    // 에러
    /*@Query("select count(distinct jobid) from Employees ")*//*
    String countDistinctByJobid();*/

}
