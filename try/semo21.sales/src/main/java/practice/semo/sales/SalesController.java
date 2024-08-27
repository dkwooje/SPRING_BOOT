package practice.semo.sales;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.semo.Member.CustomUser;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SalesController {

    private final SalesRepository salesRepository;

    @PostMapping("/order")
    String postOrder (String title,
                      Integer price,
                      Integer count,
                      Authentication auth)
    {
        Sales sales = new Sales();
        sales.setCount(count);
        sales.setPrice(price);
        sales.setItemName(title);

        CustomUser user = (CustomUser) auth.getPrincipal();
      //  sales.setMemberId(user.id);

        salesRepository.save(sales);

        return "list.html";
    }

    @GetMapping("/order/all")
    String getOrderAll(){
        List<Sales> result = salesRepository.findAll();
        System.out.println(result.get(0));
        return "list.html";
    }


}
