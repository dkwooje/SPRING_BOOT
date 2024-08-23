package practice.semo.Member;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @GetMapping("/user/1")
    @ResponseBody
    public MemberDto getUser() {
        var a = memberRepository.findById(1);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName());
        //var data = new Data();
        //data.username = result.getUsername();
        //data.displayName = result.getDisplayName();

        return data;
    }
    @GetMapping("/user/2")
    @ResponseBody
    public MemberDto getUser2() {
        var a = memberRepository.findById(1);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName());
        data.id = 3;
        return data;
    }


}

class MemberDto{   //DTO 비밀번호 가리기
    public String username; //public을 표현해야 한다.
    public String displayName;
    public Integer id;
    MemberDto(String A, String B){ //
        this.username = A;
        this.displayName = B;
    }
    MemberDto(String A, String B, Integer id){ //
        this.username = A;
        this.displayName = B;
    }
}


//(application.properties)
//server.servlet.session.timeout=5s
//server.servlet.session.cookie.max-age=5s
// 5초 지나면 로그인 자동 풀림