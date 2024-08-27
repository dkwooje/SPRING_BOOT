package practice.semo.sales;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.semo.Member.CustomUser;
import practice.semo.Member.DBMember;
import practice.semo.Member.MemberRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SalesController {

    private final SalesRepository salesRepository;
    private final MemberRepository memberRepository;

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
        var member = new DBMember();
        member.setId(user.id);
        sales.setMember(member);

        salesRepository.save(sales);

        return "list.html";
    }

    @GetMapping("/order/all")
    String getOrderAll(){
    //    List<Sales> result = salesRepository.customFindAll();
    //    System.out.println(result);

       var founds =  memberRepository.findById(1L);
        System.out.println(founds);
        return "list.html";
    }


}

class SalesDto{
    public String itemName;
    public Integer price;
    public String username;
}