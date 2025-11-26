package com.mysite.sbb.comment;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import com.mysite.sbb.user.SiteUser; // 유저 엔티티 가져오기
import com.mysite.sbb.post.Post;

@Getter
@Setter
@Entity
public class Comment 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;   // PK

    // FK: User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    // FK: Post
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String content;   // 댓글 내용

    @Column(length = 50)
    private LocalDateTime createdAt;
    
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    @Column(length = 50)
    private LocalDateTime modiftDate;
    

   
}