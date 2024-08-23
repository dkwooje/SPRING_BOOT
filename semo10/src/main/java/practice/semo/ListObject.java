package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    String edit(Model model, @PathVariable int id){

      Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            model.addAttribute("code",result.get());
            return  "edit.html";
        } else {
            return "redirect:/list";
        }
    }
/*
    @PostMapping("/edit/{id}")
    String editItem(){

       Item item = new Item();
      //  item.setId(1); //ID가 1인 행을 덮어쓰는 기능
        item.setTitle("골프");
        item.setPrice(40000);
        itemRepository.save(item);

        return "redirect:/list";
    }
*/

    @PostMapping("/edit/{id}")
    String editItem(@RequestParam String title, @RequestParam Integer price ,int id){

        itemService.editItem(title,price, id);
        return "redirect:/list";


    }
}