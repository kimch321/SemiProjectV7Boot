package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

    List<Board> selectBoard(int strbno);
    List<Board> selectBoard(Map<String, Object> params);
    Board selectOneBoard(String bno);
    int countBoard();
    int countBoard(Map<String, Object> params);
    int insertBoard(Board bd);
}
