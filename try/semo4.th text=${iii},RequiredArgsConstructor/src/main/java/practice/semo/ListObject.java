package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor

public class ListObject {

    private final Repo repo;


    @GetMapping("/list")
    List<Item> list(Model model){
        List<Item> result = repo.findAll();
        System.out.println(result);
        model.addAttribute("items",result);
        return result;
    }
}