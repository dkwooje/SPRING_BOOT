package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final ItemRepository itemRepository;
    private final ItemService itemService;


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

    @PostMapping("/add")
    String addPost(String title, Integer price){
     //  new ItemService().saveItem(String title, Integer price);
        itemService.saveItem(title,price);
        return  "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model) {

        //  commentRepository.findAllByParentId(1L);
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable Integer id){

      Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            model.addAttribute("code",result.get());
            return  "edit.html";
        } else {
            return "redirect:/list";
        }
    }


    @PostMapping("/edit/{id}")
    String editItem( String title, Integer price ,Integer id){

        itemService.editItem(title,price,id);

        return "redirect:/list";
        }

    @PostMapping("/delete")
    String deleteItem(Integer id){
        itemService.deleteItem(id);
                return "redirect:/list";
    }


        /*
// AjAX: 삭제

        @DeleteMapping("/TRASH")
        String deleteItem(@RequestParam int id){
            itemRepository.deleteById(id);
            return "redirect:/list";}


            @PostMapping("/test3")
            String test2(@RequestBody Map<String, Object> body){ //RequestParam:FORM데이터 출력
                System.out.println(body);                       //RequestBody:Body데이터 출력
                System.out.println(body.get("name3"));
                return "redirect:/list";
                //새로고침시 GET요청을 날림
    }

         */
}
