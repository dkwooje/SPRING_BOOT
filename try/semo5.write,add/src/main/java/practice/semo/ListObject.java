package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ListObject{

private final Repo repo;

@GetMapping("/list")
List<Item> list(Model model) {
    List<Item> result = repo.findAll();
    model.addAttribute("items", result);
    return result;
}

   @GetMapping("/write")
   String write(){
    return "write.html";
   }


    @PostMapping("/add")
    String write(
                @RequestParam String title,
                @RequestParam Integer price
    ){
        System.out.println(title);
        System.out.println(price);
        return "redirect:/list";
    }


/*
    @PostMapping("/add")
        //누가 /add로 POST요청하면 이거저거 해주세요
    String addPost(@RequestParam Map formData) {

        Map<String, Object> test = new HashMap<>();
        test.put("name","kim");
        test.put("age",20);
        System.out.println(test);
        System.out.println(test.get("name"));
        return "redirect:/list"; //특정페이지로 돌아가게 만듬
    }
    */
}