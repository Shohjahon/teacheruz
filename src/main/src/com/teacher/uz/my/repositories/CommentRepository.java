package com.teacher.uz.my.repositories;

import com.teacher.uz.my.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findCommentsByArticleId(Long id);
}
