package com.application.blog.api_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.application.blog.entity.Blog;
import com.application.blog.service.BlogService;


@RestController
@RequestMapping("/application")
public class BlogApiController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping("/blogs")
    public String saveBlog( @RequestBody Blog blog, @RequestParam("tags") String tags) {
        long blogId = blogService.saveBlog(blog, tags);
        return "blog saved with id " + blogId;
    }

    @PutMapping("/blogs/{id}")
    public String updateBlog(@PathVariable long id, @RequestBody Blog blog) {
        boolean isUpdated = blogService.updateBlog(id, blog);
        if (isUpdated){
            return "Blog updated successfully.";
        } else {
            return "Blog update Unsuccessful";
        }
    }

    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable long id) {
        boolean isBlogDeleted = blogService.deleteBlog(id);
        if (!isBlogDeleted) {
            return "Blog Id invalid";
        } else {
            return "Blog Deleted";
        }
    }
}
