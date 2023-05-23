package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {

     Map<String, Object> readBoard(int cpage);
     Map<String, Object> readBoard(int cpage, String ftype, String fkey);
     Board readOneBoard(int bno);
     boolean newBoard(Board bd);

}
