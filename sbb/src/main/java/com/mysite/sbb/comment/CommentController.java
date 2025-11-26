package com.mysite.sbb.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mysite.sbb.post.Post;
import com.mysite.sbb.post.PostService;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    @PostMapping("/comment/create/{postId}")
    public String createComment(
            @PathVariable Integer postId,
            @RequestParam String content) {

        Post post = postService.getPost(postId);
        SiteUser user = userService.getCurrentUser();

        commentService.create(post, user, content);

        return "redirect:/community_detail/" + postId;
    }


}
