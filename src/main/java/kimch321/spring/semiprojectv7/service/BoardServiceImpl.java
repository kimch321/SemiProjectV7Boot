package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.dao.BoardDAO;
import kimch321.spring.semiprojectv7.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bdsrv")
public class BoardServiceImpl implements BoardService{

  @Autowired
    BoardDAO bddao;

    @Override
    public List<Board> readBoard(int cpage) {
        // 1 페이지라면 limit 0,25 2 페이지라면 limit 25,25...
        int stbno = (cpage - 1) * 25;
        return bddao.selectBoard(stbno);
    }

    @Override
    public List<Board> readBoard(int cpage, String ftype, String fkey) {
        int stbno = (cpage - 1) * 25;

        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("stbno", stbno);
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return bddao.selectBoard(params);
    }

    @Override
    public int countBoard() {
        return bddao.countBoard();
    }

    @Override
    public int countBoard(String ftype, String fkey) {
        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return bddao.countBoard(params);
    }

    @Override
    public boolean newBoard(Board bd) {
        boolean result = false;

        if(bddao.insertBoard(bd) > 0) result = true;

        return result;
    }

    @Override
    public Board readOneBoard(int bno) {
        return bddao.selectOneBoard(bno);
    }
}
