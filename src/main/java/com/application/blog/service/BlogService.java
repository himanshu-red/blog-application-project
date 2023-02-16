package com.application.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.application.blog.entity.Tag;
import com.application.blog.repository.BlogRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.entity.Blog;

@Service
public class BlogService {

    @Autowired
    private BlogRepo blogRepo;
    @Autowired
    private TagService tagService;

    @Transactional
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Transactional
    public Blog getBlogById(long id) {
        Optional<Blog> result = blogRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Transactional
    public long saveBlog(Blog blog) {
        List<String> tagsList = separateTags(blog.getTags());
        for (String tag : tagsList) {
            System.out.println(tag);
        }
        blog.setTags("");
        List<Tag> tagObjects = tagService.saveTags(tagsList);
        blog.setTagsList(tagObjects);
        blogRepo.save(blog);
        return blog.getId();
    }

    private List<String> separateTags(String tags) {
        tags = tags.trim();
        List<String> tagsList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tags.length(); i++) {
            if (tags.charAt(i) != ' ' && tags.charAt(i) !=  ',') {
                stringBuilder.append(tags.charAt(i));
            }
            if ((tags.charAt(i) == ' ' || tags.charAt(i) == ',' || i == tags.length() - 1) && !stringBuilder.isEmpty()) {
                tagsList.add(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        return tagsList;
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
