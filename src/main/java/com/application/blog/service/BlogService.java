package com.application.blog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entity.Blog;
import com.application.blog.repository.BlogRepo;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepo; 
    
    @Transactional
    public List<Blog> getAllBlogs(){
        return blogRepo.findAll(); 
    }

    @Transactional
    public long saveBlog(Blog blog) {
        blogRepo.save(blog); 
        return blog.getId(); 
    }

    @Transactional
    public boolean deleteBlog(long id) {
        Optional<Blog> result = blogRepo.findById(id); 
        if (!result.isEmpty()){
            blogRepo.delete(result.get());
            return true; 
        }else{
            return false; 
        }
    }
}
