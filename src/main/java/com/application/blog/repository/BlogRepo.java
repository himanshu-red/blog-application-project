package com.application.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.blog.entity.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long>{
    
}
