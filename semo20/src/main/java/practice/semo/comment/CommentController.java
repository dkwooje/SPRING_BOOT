package practice.semo.comment;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import practice.semo.Member.CustomUser;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentRepository commentRepository;


    @PostMapping("/comment")
    String postComment(String content,
                       Long parent,
                       Authentication auth){
       CustomUser user =(CustomUser) auth.getPrincipal();

        var data = new Comment();
        data.setContent(content);
        data.setUsername(user.getUsername());
        data.setParentId(parent);
        commentRepository.save(data);

        return  "redirect:/list";
    }


}
