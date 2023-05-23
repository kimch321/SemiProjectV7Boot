package kimch321.spring.semiprojectv7.controller;

import kimch321.spring.semiprojectv7.model.Board;
import kimch321.spring.semiprojectv7.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService bdsrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board/list");
        if (cpg == null || cpg == 0) cpg = 1;

        Map<String, Object> bds = bdsrv.readBoard(cpg);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg",((cpg-1)/10)*10 + 1);
        mv.addObject("cntpg",bds.get("cntpg"));


        return mv;
    }

    @GetMapping("/find") // 검색 처리
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();

        Map<String, Object> bds = bdsrv.readBoard(cpg, ftype, fkey);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg",bds.get("cntpg"));

        mv.setViewName("board/list");
        return mv;
    }

    @GetMapping("/write")
    public String write(Model m) {

        // validation을 위한 첫번째 코드
        m.addAttribute("board", new Board());

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
    public ModelAndView view(int bno) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("bd",bdsrv.readOneBoard(bno));
        mv.setViewName("board/view");

        return mv;
    }




}
