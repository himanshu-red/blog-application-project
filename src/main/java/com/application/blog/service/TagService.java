package com.application.blog.service;

import com.application.blog.entity.Blog;
import com.application.blog.entity.Tag;
import com.application.blog.repository.BlogRepo;
import com.application.blog.repository.TagRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    TagRepo tagRepo;

    protected List<String> separateTags(String tags) {
        tags = tags.trim();
        List<String> tagsList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tags.length(); i++) {
            if (tags.charAt(i) != ' ' && tags.charAt(i) != ',') {
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
    public List<Tag> saveTags(@NotNull List<String> tagsList) {
        List<Tag> tagObjects = new ArrayList<>();
        for (String tagName : tagsList) {
            Tag tag = new Tag();
            List<Tag> savedTags = tagRepo.findByName(tagName);
            if (savedTags.isEmpty()) {
                tag.setName(tagName);
                tagRepo.save(tag);
            } else {
                tag = savedTags.get(0);
            }
            tagObjects.add(tag);
        }
        return tagObjects;
    }

    public void deleteTagIfWithoutBlogs(@NotNull List<Tag> tagsList) {
        for (Tag tag : tagsList) {
            if (tag.getBlogs().size() <= 1) {
                deleteTag(tag);
            }
        }
    }

    @Transactional
    private void deleteTag(Tag tag) {
        tagRepo.delete(tag);
    }
}
