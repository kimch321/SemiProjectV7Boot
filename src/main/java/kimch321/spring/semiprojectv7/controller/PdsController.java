package kimch321.spring.semiprojectv7.controller;

import kimch321.spring.semiprojectv7.model.Pds;
import kimch321.spring.semiprojectv7.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pds")
public class PdsController {

    @Autowired
    PdsService pdssrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pds/list");
        if (cpg == null || cpg == 0) cpg = 1;

        Map<String, Object> pds = pdssrv.readPds(cpg);

        mv.addObject("pdslist", pds.get("pdslist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", pds.get("cntpg"));

        return mv;
    }

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("pds", new Pds());

        return "pds/write";
    }

    /*MultipartFile attach: 파일 업로드를 위해 전달된 파일 데이터를 처리하기 위한
     MultipartFile 객체를 매개변수로 받습니다.*/
    @PostMapping("/write")
    public String writeok(Pds pds, MultipartFile attach) {
        String viewPage = "error";

        Map<String, Object> pinfo = pdssrv.newPds(pds);

        if (!attach.isEmpty()) // 첨부파일이 존재한다면
            pdssrv.newPdsAttach(attach, pinfo);

        viewPage = "redirect:/pds/list";

        return viewPage;
    }

    @GetMapping("/view")
    public String view(int pno, Model m) {
        m.addAttribute("pds", pdssrv.readOnePds(pno));
        m.addAttribute("attach", pdssrv.readOnePdsAttach(pno));

        return "pds/view";
    }

    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) {

        // 업로드 파일의 uuid와 파일명 알아냄
        String uuid = pdssrv.readOnePds(pno).getUuid();
        String fname = pdssrv.readOnePdsAttach(pno).getFname();

        // 알아낸 uuid와 파일명을 이용해서 header와 리소스 객체 생성
        //HttpHeaders는 HTTP 응답 헤더를 구성하는 데 사용되는 클래스입니다.
        // HTTP 응답 헤더는 클라이언트에게 전달되는 정보로,
        // 예를 들어 콘텐츠 유형(Content-Type),
        // 콘텐츠 길이(Content-Length),
        // 캐시 제어(Cache-Control) 등의 정보를 포함할 수 있습니다.
        // HttpHeaders 객체를 사용하여 이러한 헤더 정보를 설정할 수 있습니다.
        HttpHeaders header = pdssrv.getHeader(fname, uuid);
        //UrlResource: 파일 다운로드를 위해 사용되는 객체
        //리소스 객체는 파일이나 네트워크 리소스 등의 데이터를 추상화하여 제공합니다.
        // 파일 다운로드를 위해 사용되는 리소스 객체는 다운로드할 파일의
        // 실제 데이터를 가지고 있습니다.
        // 이 리소스 객체를 클라이언트에게 전달하여 파일을 다운로드할 수 있습니다.
        UrlResource resource = pdssrv.getResource(fname, uuid);

        return ResponseEntity.ok().headers(header).body(resource);
    }


}
