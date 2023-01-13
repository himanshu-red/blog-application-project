package com.application.blog.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.entity.Blog;
import com.application.blog.service.BlogService;

@RestController
// @RequestMapping
public class BlogApiController {
    
    @Autowired
    private BlogService blogService; 

    @GetMapping("/blogs")
    public List<Blog> getBlogs(){
        System.out.println(">> inside the getBlogs");
        System.out.println(blogService.getAllBlogs().size());
        return blogService.getAllBlogs(); 
    }

    @PostMapping("/blogs")
    public String saveBlog(@RequestBody Blog blog){
        System.out.println("");
        blog.setId(0);
        long blogId = blogService.saveBlog(blog); 
        return "blog saved with id " + blogId; 
    }

    @PutMapping("/blogs/{id}")
    public String updateBlog(@PathVariable long id, @RequestBody Blog blog){
        blog.setId(id);
        blogService.saveBlog(blog); 
        return "Blog with id " + id + " update. ";
    }
}
