package practice.semo.Comment;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.semo.Member.CustomUsers;


@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    //@PreAuthorize()
    @PostMapping("/comment")
    String postComment(
            @RequestParam String content,
            @RequestParam Long parent,
            Authentication auth)
    {
        CustomUsers user = (CustomUsers)auth.getPrincipal();
        var data = new Comment();
        data.setContent(content);
        data.setUsername(user.getUsername());
        data.setParentId(parent);
        commentRepository.save(data);
        return"redirect:/list";
    }

}

