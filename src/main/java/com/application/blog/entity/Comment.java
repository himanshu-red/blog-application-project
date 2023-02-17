package com.application.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    private String theComment; 
    @CreationTimestamp
    private java.time.LocalDateTime created_at; 
    @UpdateTimestamp
    private java.time.LocalDateTime updated_at; 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_id")
    @ToString.Exclude
    @JsonIgnore
    private Blog blog; 
}
