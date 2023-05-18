package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<Board> selectBoard(int stbno) {
        return sqlSession.selectList("board.selectBoard", stbno);
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        return sqlSession.selectList("board.selectFindBoard", params);
    }

    @Override
    public Board selectOneBoard(String bno) {

        sqlSession.update("board.countViewBoard", bno);
        return sqlSession.selectOne("board.selectOneBoard", bno);
    }

    @Override
    public int countBoard() {
        return sqlSession.selectOne("board.countBoard");
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return sqlSession.selectOne("board.countFindBoard", params);
    }

    @Override
    public int insertBoard(Board bd) {
        return sqlSession.insert("board.insertBoard", bd);
    }
}
