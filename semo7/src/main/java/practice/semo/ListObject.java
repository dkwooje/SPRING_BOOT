package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final ItemRepository itemRepository; //constructor로 대체 가능

    @GetMapping("/list")
    List<Item> list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return result;
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    /*
    @GetMapping("/detail/1")
    String addPost1(){
            return  "redirect:/list";
    }


    @GetMapping("/detail/2")
    String addPost2(){
        return  "redirect:/list";
    }

    @GetMapping("/detail/3")
    String addPost3(){
        return  "redirect:/list";
    }
    */
    /*
    @GetMapping("/detail/{id}")  //URL 파라미터 문법
    String detail(){
       Optional<Item> result = itemRepository.findById(1);  //Optional : 변수가 비어있을 수도 있고 item일수 있다.
        System.out.println(result.get());                   //findById를 사용하기 위한 변수이기도 하다
        return  "detail.html";}
    */
    /*
    @GetMapping("/detail/{id}")  //URL 파라미터 문법
    String detail(){
        Optional<Item> result = itemRepository.findById(2);  //Optional : 변수가 비어있을 수도 있고 item일수 있다.
        if(result.isPresent() ){                            //findById를 사용하기 위한 변수이기도 하다
            System.out.println(result.get());
        }
        return  "detail.html";}
    */
    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model) {

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }
}