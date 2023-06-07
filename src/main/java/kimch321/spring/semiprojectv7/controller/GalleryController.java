package kimch321.spring.semiprojectv7.controller;

import kimch321.spring.semiprojectv7.model.Pds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @GetMapping("/list")
    public ModelAndView list(@RequestParam int cpg) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("cpg",cpg);
        mv.addObject("stpg",((cpg-1)/10)*10 + 1);
        mv.setViewName("gallery/list");
        return mv;
    }

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("pds", new Pds());

        return "gallery/write";
    }

    /*MultipartFile attach: 파일 업로드를 위해 전달된 파일 데이터를 처리하기 위한
     MultipartFile 객체를 매개변수로 받습니다.*/
    @PostMapping("/write")
    public String writeok(Pds pds, MultipartFile attach) {
        String viewPage = "error";

        /*Map<String, Object> pinfo = pdssrv.newPds(pds);

        if (!attach.isEmpty()) // 첨부파일이 존재한다면
            pdssrv.newPdsAttach(attach, pinfo);

        viewPage = "redirect:/gallery/list";*/

        return viewPage;
    }

}
