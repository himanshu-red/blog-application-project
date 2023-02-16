package com.application.blog.service;

import com.application.blog.entity.Blog;
import com.application.blog.entity.Tag;
import com.application.blog.repository.BlogRepo;
import com.application.blog.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;
    @Autowired
    BlogService blogService;

//    @Transactional
//    public long saveTag(String tags, long blog_id){
//        List<String> tagsList = separateTags(tags);
//        Blog blog  = blogService.getBlogById(blog_id);
//        blog.getTags().add(tag);
//        blogService.saveBlog(blog);
//        return tag.getId();
//    }

//    private List<String> separateTags(String tags) {
//        tags = tags.trim();
//        List<String> tagsList = new ArrayList<>();
//        String separatedTag = "";
//        for (int i = 0; i < tags.length(); i++){
//            if ((tags.charAt(i) == " ") || (tags.charAt(i) != ",")){
//
//            }
//        }
//
//    }

//    @Transactional
//    public List<Tag> getTagsOfA_BlogId(long blogId){
//
//    }
}
