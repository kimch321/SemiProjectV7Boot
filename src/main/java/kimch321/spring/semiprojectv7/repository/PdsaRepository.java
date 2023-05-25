package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.PdsAttach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdsaRepository extends JpaRepository<PdsAttach, Long> {
    PdsAttach findByPno(int pno);

}
