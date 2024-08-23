package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    List<Item> list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return result;
}
        @GetMapping("/write")
    String write(){
        return "write.html";
        }

     @PostMapping
    String add(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect.html";
     }

/*
    @PostMapping("/add")
    String write(@ModelAttribute Item item) {

        System.out.println(item);
        itemRepository.save(item);
        return "redirect:/list";

    }

*/
}