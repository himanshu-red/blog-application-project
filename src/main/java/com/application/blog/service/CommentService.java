package com.application.blog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entity.Blog;
import com.application.blog.entity.Comment;
import com.application.blog.repository.BlogRepo;
import com.application.blog.repository.CommentRepo;

@Service
public class CommentService {

    @Autowired
    private BlogRepo blogRepo;
    @Autowired
    private CommentRepo commentRepo; 

    @Transactional
    public List<Comment> getComments(long blogId) {
        Optional<Blog> result = blogRepo.findById(blogId);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get().getComments();
        }
    }

    @Transactional
    public long saveComment(Comment comment, long blogId) {
        Optional<Blog> result = blogRepo.findById(blogId);
        if (result.isEmpty()){
            return -1; 
        }else{
            Blog blog = result.get(); 
            comment.setBlog(blog);
            System.out.println(">> before saving comment : " + comment);
            commentRepo.save(comment); 
            return comment.getId();   
        }
    }
}
