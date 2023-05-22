package kimch321.spring.semiprojectv7.dao;

import kimch321.spring.semiprojectv7.model.Board;
import kimch321.spring.semiprojectv7.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bddao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> selectBoard(int cpage) {
        Pageable paging = // PageRequest.of(cpage, 25, Sort.by("bno").descending());
        PageRequest.of(cpage, 25, Sort.Direction.DESC, "bno");

        return boardRepository.findAll(paging).getContent();
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        // like 검색에 대한 query - method
        // findByTitleLike          : %검색어% (% 문자제공 필요)
        // findByTitleContains      : %검색어% (% 문자제공 필요x)
        // findByTitelStartsWith    : 검색어% (% 문자제공 필요x)
        // findByTitelEndsWith      : %검색어 (% 문자제공 필요x)


        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();
        int cpage = (int) params.get("stbno");
        Pageable paging = PageRequest.of(cpage, 25, Sort.by("bno").descending());

        List<Board> result = null;

        switch(ftype) {
            case "title": // 제목으로 검색
                result = boardRepository.findByTitleContains(paging, fkey);
                break;
            case "titcont": // 제목 + 본문으로 검색
                result = boardRepository.findByTitleContainsOrContentContains(paging, fkey,fkey);
                break;
            case "userid": // 작성자로 검색
                result = boardRepository.findByUserid(paging, fkey);
                break;
            case "content": // 본문으로 검색
                result = boardRepository.findByContentContains(paging, fkey);
                break;
        }

        return result;
    }

    @Override
    public Board selectOneBoard(int bno) {
        boardRepository.countViewBoard((long) bno);
        return boardRepository.findById((long) bno).get();
    }

    @Override
    public int countBoard() {
        // select ceil(count(bno)/25) from board;
        int allCnt = boardRepository.countBoardBy();
        return (int) Math.ceil(allCnt / 25);
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();

        int cnt = 0;

        switch(ftype) {
            case "title": // 제목으로 검색
                cnt = boardRepository.findByTitleContains(fkey);
                break;
            case "titcont": // 제목 + 본문으로 검색
                cnt = boardRepository.findByTitleContainsOrContentContains(fkey, fkey);
                break;
            case "userid": // 작성자로 검색
                cnt = boardRepository.findByUserid(fkey);
                break;
            case "content": // 본문으로 검색
                cnt = boardRepository.findByContentContains(fkey);
                break;
        }
        return (int) Math.ceil(cnt/25);
    }

    @Override
    public int insertBoard(Board bd) {
        return Math.toIntExact(boardRepository.save(bd).getBno());
    }
}
