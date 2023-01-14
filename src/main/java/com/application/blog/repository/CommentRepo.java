package com.application.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    
}
