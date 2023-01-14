package com.application.blog.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.entity.Comment;
import com.application.blog.service.CommentService;

@RestController
@RequestMapping("/application")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{blog_id}")
    public List<Comment> getComments(@PathVariable(name = "blog_id") int blogId) {
        return commentService.getComments(blogId);
    }

    @PostMapping("/comments/{blog_id}")
    public String saveComment(@PathVariable(name = "blog_id") long blogId, @RequestBody Comment comment) {
        System.out.println(">> printing out comment : " + comment);
        long commentId = commentService.saveComment(comment, blogId);
        System.out.println(">> comment id returned : " + commentId);
        if (commentId != 0) {
            return "Comment saved with id : " + comment.getId();
        } else {
            return "Comment save unsuccessful";
        }
    }
}
