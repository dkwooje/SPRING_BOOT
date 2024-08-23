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

    private final ItemRepository itemRepository;
    private final ItemService itemService;
/*
    public ListObject(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }
    //@RequiredArgsConstructor사용하지 않을시 문법
    //object알아서 뽑아서 itemService itemRepository에 넣으라는 뜻
    //이 원리가 container와 bean이다.
*/
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

@PostMapping("/add")
    String addpost(String title, Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
}

  /*  @PostMapping("/add")
    String add(String title, Integer price){
        Item item = new Item();
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);
        return "redirect:/list";
    }
*/

}