package practice.semo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ListObject {

    private final Repo repo; //constructor로 대체 가능

    @GetMapping("/list")
    List<Item> list(Model model) {
        List<Item> result = repo.findAll();
        System.out.println(result);

        ArrayList aaa = new ArrayList<>();
        aaa.add(40);
        aaa.add(50);
        aaa.add(60);
        aaa.add(70);
        System.out.println(aaa.get(0));
        System.out.println(aaa.get(1));
        System.out.println(aaa.get(2));


        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());

        return result;

    }
}
