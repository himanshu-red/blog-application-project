package com.application.blog.service;

import java.util.List;
import java.util.Optional;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entity.Blog;
import com.application.blog.repository.BlogRepo;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Transactional
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Transactional
    public Blog getBlogById(long id){
        Optional<Blog> result = blogRepo.findById(id);
        if (result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Transactional
    public long saveBlog(Blog blog) {
        blogRepo.save(blog);
        return blog.getId();
    }

    @Transactional
    public boolean deleteBlog(long id) {
        Optional<Blog> result = blogRepo.findById(id);
        if (result.isPresent()) {
            blogRepo.delete(result.get());
            return true;
        } else {
            return false;
        }
    }
}
