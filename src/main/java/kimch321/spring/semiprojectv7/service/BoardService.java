package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {

     Map<String, Object> readBoard(int cpage);
     List<Board> readBoard(int cpage, String ftype, String fkey);
     Board readOneBoard(int bno);
     int countBoard(String ftype, String fkey);
     public boolean newBoard(Board bd);

}
