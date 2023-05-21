package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Board;
import kimch321.spring.semiprojectv7.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> selectBoard(int strbno) {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        return null;
    }

    @Override
    public Board selectOneBoard(int bno) {
        return boardRepository.findById((long) bno).get();
    }

    @Override
    public int countBoard() {
        return 0;
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int insertBoard(Board bd) {
        return Math.toIntExact(boardRepository.save(bd).getBno());
    }
}
