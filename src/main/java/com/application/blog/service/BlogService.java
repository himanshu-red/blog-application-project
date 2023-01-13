package com.application.blog.service;

import java.util.List;

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


}
