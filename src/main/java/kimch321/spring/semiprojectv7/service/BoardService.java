package kimch321.spring.semiprojectv7.service;

import kimch321.spring.semiprojectv7.model.Board;

import java.util.List;

public interface BoardService {

     List<Board> readBoard(int cpage);
     List<Board> readBoard(int cpage, String ftype, String fkey);
     Board readOneBoard(int bno);
     int countBoard();
     int countBoard(String ftype, String fkey);
     public boolean newBoard(Board bd);

}
