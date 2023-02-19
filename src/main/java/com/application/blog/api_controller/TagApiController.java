package com.application.blog.api_controller;

import com.application.blog.entity.Tag;
import com.application.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class TagApiController {
    @Autowired
    TagService tagService;

    @GetMapping("/tag/{blog_id}")
    public List<Tag> getTagsOfA_Blog(@PathVariable long blog_id){
        return tagService.getTagsOfA_Blog(blog_id);
    }
}
