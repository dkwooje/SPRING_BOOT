package practice.semo.Member;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;




@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(String username, String password, String displayName) {
        memberService.addMember(username, password, displayName);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login(String username) {
        var result = memberRepository.findByUsername(username);
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


//implementation 'org.springframework.session:spring-session-jdbc' 설치하지 말것!!!!

/*
@GetMapping("/user/1")
@ResponseBody
public DBMember getUser(){
    var a = memberRepository.findById(1);
    var result = a.get();
    return result;
    }
}
*/


@GetMapping("v1/user/{id}")
@ResponseBody
public MemberDto getUser1(@PathVariable Integer id) {
    var a = memberRepository.findById(id);
    var result = a.get();
    var data = new MemberDto(result.getUsername(), result.getDisplayName());
    return data;
}

    @GetMapping("v2/user/{id}")
    @ResponseBody
    public MemberDto getUser2(@PathVariable Integer id) {
        var a = memberRepository.findById(id);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName(), result.getId());
        return data;
    }

}

class MemberDto{   //DTO 비밀번호 가리기
    public String username;    //public을 표현해야 한다.
    public String displayName;
    public Integer id;
    MemberDto(String A, String B){ //
        this.username = A;
        this.displayName = B;
    }
    MemberDto(String A, String B, Integer C){ //
        this.username = A;
        this.displayName = B;
        this.id = C;
    }
}