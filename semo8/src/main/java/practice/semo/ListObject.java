package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        @GetMapping("/detail/{id}")
        String detail(@PathVariable Integer id, Model model) throws Exception { //throws 예외상황 출력 할 수 있다.
            try {
               // throw new Exception("그냥");
                Optional<Item> result = itemRepository.findById(id);
                if (result.isPresent()) {
                    model.addAttribute("data", result.get());
                    return "detail.html";
                } else {
                    return "redirect:/list";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return "redirect:/list"; //보통 문자나 에러문자를 보낸다.
              //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ㅋㅋㅋㅋㅋ"); //status:에러코드 body:에러내용 기입
            }                                                                         //HttpStatus: 에러코드 자동 출력
        }
    */
    @GetMapping("/detail/{id}") //유저가 잘못 입력하여 생긴 에러 캐치방법
    String detail(@PathVariable Integer id, Model model) throws Exception { //throws 예외상황 출력 할 수 있다.
        Optional<Item> result = itemRepository.findById(id);

         throw new Exception("그냥");
         /*
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
          */
    }
}