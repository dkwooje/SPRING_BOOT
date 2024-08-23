package practice.semo.Member;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/register")
    String register(){
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(String username, String password, String displayName){
       DBMember member =  new DBMember();
       var hash = passwordEncoder.encode(password);
       member.setPassword(password);
       member.setUsername(username);
       member.setDisplayName(displayName);
        memberRepository.save(member);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
       var result = memberRepository.findByUsername("kim");
        System.out.println(result.get().getDisplayName());
        return "login.html";
    }
}
