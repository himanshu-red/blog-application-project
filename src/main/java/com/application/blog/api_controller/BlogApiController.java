package com.application.blog.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.entity.Blog;
import com.application.blog.service.BlogService;

@RestController
@RequestMapping
public class BlogApiController {
    
    @Autowired
    private BlogService blogService; 

    @GetMapping("/blogs")
    public List<Blog> getBlogs(){
        return blogService.getAllBlogs(); 
    }

    @PostMapping("/blogs")
    public String saveBlog(@RequestBody Blog blog){
        System.out.println("");
        blog.setId(0);
        long blogId = blogService.saveBlog(blog); 
        return "blog saved with id " + blogId; 
    }
}
