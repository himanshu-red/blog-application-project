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

    @Transactional
    public List<Tag> saveTags(List<String> tagsList) {
        List<Tag> tagObjects = new ArrayList<>();
        for (String tagName: tagsList){
            Tag tag = new Tag();
            List<Tag> savedTags = tagRepo.findByName(tagName);
            if (savedTags.isEmpty()) {
                tag.setName(tagName);
                tagRepo.save(tag);
            }else{
                tag = savedTags.get(0);
            }
            tagObjects.add(tag);
        }
        return tagObjects;
    }

}
