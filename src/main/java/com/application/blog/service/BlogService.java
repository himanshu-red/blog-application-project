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
        String tags = blog.getTags();
//        System.out.println("Tags : " + tags);
        if (!tags.isEmpty()) {
            List<String> tagsList = tagService.separateTags(tags);
            List<Tag> tagObjects = tagService.saveTags(tagsList);
            blog.setTagsList(tagObjects);
            blog.setTags("");
        }
        blogRepo.save(blog);
        return blog.getId();
    }


    @Transactional
    public boolean deleteBlog(long id) {
        Optional<Blog> result = blogRepo.findById(id);
        if (result.isPresent()) {
            Blog blog = result.get();
            List<Tag> tagsList = blog.getTagsList();
            blogRepo.delete(blog);
             tagService.deleteTagIfWithoutBlogs(tagsList);
            return true;
        } else {
            return false;
        }
    }
}
