package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final Repo repo; //constructor로 대체 가능

    @GetMapping("/list")
    List<Item> list(Model model) {
        List<Item> result = repo.findAll();
        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());

        return result;

    }
}
