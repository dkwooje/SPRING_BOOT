package practice.semo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ItemController {

    @GetMapping("/list")
    //@ResponseBody
    String list(Model model) {
        model.addAttribute("name","핫바지");
        return "list.html";
        //HTML에 서버데이터를 넣으려면 우선 templates 폴더에 .html파일을 넣어야한다.
        //model.addAttribute("name", "핫바지");
    }
}
