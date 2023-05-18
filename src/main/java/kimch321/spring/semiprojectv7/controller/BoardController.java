package kimch321.spring.semiprojectv7.controller;

import kimch321.spring.semiprojectv7.model.Board;
import kimch321.spring.semiprojectv7.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService bdsrv;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam int cpg) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("bdlist", bdsrv.readBoard(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg",((cpg-1)/10)*10 + 1);
        mv.addObject("cntpg",bdsrv.countBoard());

        mv.setViewName("board/list");
        return mv;
    }

    @GetMapping("/find") // 검색 처리
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("bdlist", bdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bdsrv.countBoard(ftype, fkey));
        mv.setViewName("board/list");
        return mv;
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board bd) {
        String viewPage = "error";

        if(bdsrv.newBoard(bd))
            viewPage = "redirect:/board/list?cpg=1";
        return viewPage;
    }

    @GetMapping("/view")
    public ModelAndView view(String bno) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bd",bdsrv.readOneBoard(bno));
        mv.setViewName("board/view");

        return mv;
    }




}
