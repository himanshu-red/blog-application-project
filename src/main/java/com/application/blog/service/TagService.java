package com.application.blog.service;

import com.application.blog.entity.Blog;
import com.application.blog.entity.Tag;
import com.application.blog.repository.BlogRepo;
import com.application.blog.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;
    @Autowired
    blogService blogService;

    @Transactional
    public long saveTag(Tag tag, long blog_id){
        Blog blog  = blogService.get
        tagRepo.save(tag);
        return tag.getId();
    }

//    @Transactional
//    public List<Tag> getTagsOfA_BlogId(long blogId){
//
//    }
}
