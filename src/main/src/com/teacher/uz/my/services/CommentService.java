package com.teacher.uz.my.services;

import com.teacher.uz.my.domains.Comment;
import com.teacher.uz.my.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shoh Jahon on 04.05.2018.
 */
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }
    public Comment getComment(int id){
        return commentRepository.findOne(Long.valueOf(id));
    }
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }
    public void deleteComment(int id){
        commentRepository.delete(Long.valueOf(id));
    }
    public List<Comment> getCommentsByArticle(int id){
        return commentRepository.findCommentsByArticleId(Long.valueOf(id));
    }
}
