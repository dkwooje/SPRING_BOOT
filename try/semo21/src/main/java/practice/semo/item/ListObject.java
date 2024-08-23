package practice.semo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final S3Service s3Service;


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
                         //@RequestParam 생략 가능
        Item item = new Item();
        item.setId(id);
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);

        return "redirect:/list";
        }


// AjAX:새로고침없이 서버로 요청을 날리는 자바스크립트 코드
        @GetMapping("/test2")
        String test1(@RequestParam String name1, String name2){
            System.out.println("GET요청들어옴");
            System.out.println(name1);
            System.out.println(name2);
            return "redirect:/list";}
        //새로고침시 GET요청을 날림

            @PostMapping("/test3")
            String test2(@RequestBody Map<String, Object> body){ //RequestParam:FORM데이터 출력
                System.out.println(body);                       //RequestBody:Body데이터 출력
                System.out.println(body.get("name3"));
                return "redirect:/list";
                //새로고침시 GET요청을 날림

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

    @ResponseBody
    @GetMapping("/presigned-url")
    String getURL(@RequestParam String filename) {
        var result = s3Service.createPresignedUrl("test/"+filename);
        System.out.println(result);
        return result;
    }
}
