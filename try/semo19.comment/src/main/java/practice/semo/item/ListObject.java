package practice.semo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.semo.comment.Comment;
import practice.semo.comment.CommentRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final CommentRepository commentRepository;

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

    @PostMapping("/delete/{id}")
    String deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
        return "redirect:/list";
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

    @PostMapping("/edit/{id}")
    String editItem(@RequestParam String title, @RequestParam Integer price ,Integer id){
        itemService.editItem(title,price,id);
        return "redirect:/list";
        }

    //페이지 네이션
    @GetMapping("/list/page/{abc}")
    String getListPage(Model model, @PathVariable Integer abc) {

        Page<Item> result = itemRepository.findPageBy(PageRequest.of(abc -1, 5));
        result.getTotalPages(); //전체페이지 개수 알려줌
        result.hasNext();//다음페이지 있는지 알려줌
        model.addAttribute("items", result);
        return "list.html";
    }
    }

