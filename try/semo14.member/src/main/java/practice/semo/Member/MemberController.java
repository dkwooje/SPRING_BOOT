package practice.semo.Member;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class MemberController {

    private final  MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @GetMapping("/register")
    String register(){
        return "register.html";
    }




@PostMapping("/member")
String addMember(String username,
                 String displayName,
                 String password

){

    memberService.addMember(username,displayName,password);
    return "redirect:/list";
}
}
