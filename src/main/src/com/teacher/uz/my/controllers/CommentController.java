package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Article;
import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.Comment;
import com.teacher.uz.my.domains.User;
import com.teacher.uz.my.services.ArticleService;
import com.teacher.uz.my.services.CommentService;
import com.teacher.uz.my.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired 
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ModelAndView showManageComments(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCommentList",true);
        mv.addObject("title", "Comment");
        return mv;
    }

    @RequestMapping(value = "/create/comment",method = RequestMethod.GET)
    public ModelAndView showCreateComment(){
        ModelAndView mv = new ModelAndView("dashboard");
        Comment comment = new Comment();
        mv.addObject("title","Comment");
        mv.addObject("formcomment",comment);
        mv.addObject("userClickCreateComment",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/comment",method = RequestMethod.GET)
    public ModelAndView showUpdateComment(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateComment",true);
        mv.addObject("title","Update Comment");
        Comment comment = commentService.getComment(id);
        mv.addObject("formcomment",comment);
        return mv;
    }
    @RequestMapping(value = "/create/comment", method = RequestMethod.POST)
    public String showCreateComment(@ModelAttribute("comment") Comment comment){
        commentService.saveComment(comment);
        return "redirect:/comment/comments";
    }


    @RequestMapping(value = "/delete/{id}/comment", method = RequestMethod.POST)
    @ResponseBody
    public String handleCommentDeletion(@PathVariable int id){
        commentService.deleteComment(id);
        return "You have successfully removed this comment!";
    }

    @RequestMapping(value = "/comment/{id}/user",method = RequestMethod.POST)
    @ResponseBody
    public List<Comment> getComments(@PathVariable("id") int id,@ModelAttribute("comment") Comment comment){
        String full = comment.getComment();
        String arr[] = full.split("#");
        int articleId = Integer.parseInt(arr[1]);
        User user = userService.getUser(Long.valueOf(id));
        String comm = arr[0];
        Article article  = articleService.getArticle(articleId);
        Comment comment1 = new Comment();
        comment1.setUser(user);
        comment1.setArticle(article);
        comment1.setComment(comm);
        commentService.saveComment(comment1);
        List<Comment> comments = commentService.getCommentsByArticle(articleId);
        return comments;
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        List<User> users = userService.getAllUsers();
        for (int i = 0; i <users.size() ; i++) {
            users.get(i).setFullName(users.get(i).getId()+"-"+users.get(i).getLastName()+" "+users.get(i).getFirstName());
        }
        return users;
    }
    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }
    
    @ModelAttribute("articles")
    public List<Article> getArticles(){
        return articleService.getAllArticles();
    }
    @ModelAttribute("article")
    public Article getArticle(){
        return new Article();
    }

    @ModelAttribute("comments")
    public List<Comment> getComments(){
        return commentService.getAllComments();
    }
    @ModelAttribute("commentResponse")
    public Comment getComment(){
        return new Comment();
    }
}
