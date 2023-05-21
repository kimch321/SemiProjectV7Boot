package kimch321.spring.semiprojectv7.repository;

import kimch321.spring.semiprojectv7.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
