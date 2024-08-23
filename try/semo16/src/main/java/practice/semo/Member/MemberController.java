package practice.semo.Member;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(String username, String password, String displayName) {
        DBMember member = new DBMember();
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

//Authentication auth 현재 로그인 된 사람의 정보
@GetMapping("/mypage")
public String myPage(Authentication auth) {
    System.out.println(auth);
    System.out.println(auth.getName());
    System.out.println(auth.isAuthenticated());
    return "mypage.html";
}
}

//(application.properties)
//server.servlet.session.timeout=5s
//server.servlet.session.cookie.max-age=5s
// 5초 지나면 로그인 자동 풀림