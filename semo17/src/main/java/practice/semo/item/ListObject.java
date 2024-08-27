package practice.semo.item;

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
      model.addAttribute("items",result);
      return result;
  }


    @GetMapping("/write")
    String write() {
        return "write.html";
    }

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

    @PostMapping("/add")
    String addPost(String title, Integer price){
     //  new ItemService().saveItem(String title, Integer price);
        itemService.saveItem(title,price);
        return  "redirect:/list";
    }

    // AjAX: 삭제
    @DeleteMapping("/AAA")
    String deleteItem(@RequestParam int id){
        itemRepository.deleteById(id);
        return "redirect:/list";}


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

    @PostMapping("/edit/{id}")
    String editItem(@RequestParam String title, @RequestParam Integer price ,Integer id){
        itemService.editItem(title,price,id);
        return "redirect:/list";
        }

    @PostMapping("/delete/{id}")
    String deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
        return "redirect:/list";
    }

    }

