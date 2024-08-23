package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;



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

    @PostMapping("/add")
    String write(String title, Integer price) {

        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";

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