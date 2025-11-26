package com.mysite.sbb.comment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.sbb.post.Post;
import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment create(Post post, SiteUser user, String content) {
        Comment comment = new Comment();

        comment.setPost(post);
        comment.setUser(user);
        comment.setContent(content);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }
    
    public List<Comment> getComments(Integer postId) {
        return commentRepository.findByPostIdOrderByCreatedAtAsc(postId);
    }

    public int getCommentCount(Integer postId) {
        return commentRepository.countByPostId(postId);
    }

}
