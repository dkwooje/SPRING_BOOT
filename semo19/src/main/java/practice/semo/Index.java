package practice.semo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller   // public static void main(String[] args) 없이 실행 가능
public class Index {
    @GetMapping("/")
    @ResponseBody  // return의 값을 그대로 가져온다.
    String hello() {
        return "<h4>반갑습니다.</h4>";
    }
    @GetMapping("/about")  //  http://localhost:8080/about으로 접속할 수 있다.
    @ResponseBody
    String about() {
        return ZonedDateTime.now().toString();
    }
    @GetMapping("/boola")
    String boola() {
        return "index.html";  // main/resources/static 안의 파일 가져올 수 있다.
    }
}