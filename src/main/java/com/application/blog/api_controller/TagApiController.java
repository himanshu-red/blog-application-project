package com.application.blog.api_controller;

import com.application.blog.entity.Tag;
import com.application.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application")
public class TagApiController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags/{blog_id}")
    public String saveTag(@RequestBody Tag tag, @PathVariable long blog_id){
        tagService.saveTag(tag, blog_id);
    }


}
