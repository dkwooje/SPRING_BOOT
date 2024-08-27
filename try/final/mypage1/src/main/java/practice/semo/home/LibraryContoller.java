package practice.semo.home;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

@RequiredArgsConstructor
public class LibraryContoller {

    private final LibraryRepository libraryRepository;
    private final LibraryService libraryService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/home")
    String home(){
        return "/homepages/home.html";
    }

    @GetMapping("/homepages/register")
    String register(){
        return "homepages/register";
    }

    @PostMapping("/homepages/member")
    public String showRegisterPage(String a_m_id,
                                   String a_m_pw,
                                   String a_m_name,
                                   String a_m_gender,
                                   String a_m_mail,
                                   String a_m_phone
                                   )
    {
        libraryService.addperson(a_m_id, a_m_pw, a_m_name, a_m_gender, a_m_mail, a_m_phone);
        return "redirect:/homepages/home";
    }


    @GetMapping("/homepages/login")
    public String showLoginPage() {
        return "homepages/login";
    }


}
