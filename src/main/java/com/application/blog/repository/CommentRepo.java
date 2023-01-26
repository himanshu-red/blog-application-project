package com.application.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.blog.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c.updated_at FROM comment c WHERE c.id = :id", nativeQuery = true)
    public java.time.LocalDateTime getLastUpdatedTime(@Param("id") long commentId);

    @Query(value = "SELECT c.the_comment from comment c where c.id = :id", nativeQuery = true)
    public String getCommentById(@Param("id") long commentId); 
}
