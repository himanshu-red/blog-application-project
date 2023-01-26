package com.application.blog.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
@JsonIgnoreProperties({ "blog" })
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
    private Blog blog; 
}
