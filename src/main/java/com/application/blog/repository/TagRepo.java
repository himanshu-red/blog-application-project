package com.application.blog.repository;

import com.application.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {

    List<Tag> findByName(String name);

    @Query(value = "SELECT * from tag  WHERE id in (SELECT tag_id from blog_tag where blog_id = ?1)", nativeQuery = true)
    List<Tag> getTagsOfA_Blog(long blogId);

}
