package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.*;
import com.teacher.uz.my.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ThumbnailService thumbnailService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ModelAndView showManageArticles(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickArticleList",true);
        mv.addObject("title", "Article");
        return mv;
    }

    @RequestMapping(value = "/create/article",method = RequestMethod.GET)
    public ModelAndView showCreateArticle(){
        ModelAndView mv = new ModelAndView("dashboard");
        Article article = new Article();
        mv.addObject("title","Article");
        mv.addObject("article",article);
        mv.addObject("userClickCreateArticle",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/article",method = RequestMethod.GET)
    public ModelAndView showUpdateArticle(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateArticle",true);
        mv.addObject("title","Update Article");
        Article article = articleService.getArticle(id);
        mv.addObject("article",article);
        return mv;
    }
    @RequestMapping(value = "/create/article", method = RequestMethod.POST)
    public String showCreateArticle(@ModelAttribute("article") Article article,
                                            Model model,
                                            HttpServletRequest request) throws IOException {
        articleService.saveArticel(article);

        if (!article.getVideoContent().getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:\\Teacher.uz\\MyTeacher.Uz\\src\\main\\webapp\\resources\\videos", article.getVideoUrl())+".mp4"));
            outputStream.write(article.getVideoContent().getBytes());
            outputStream.flush();
            outputStream.close();
        }
            return "redirect:/article/articles";
    }

    @RequestMapping(value = "/delete/{id}/article", method = RequestMethod.POST)
    @ResponseBody
    public String handleArticleDeletion(@PathVariable int id){
        articleService.deleteArticle(id);
        return "You have successfully removed this article! id: "+id;
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        List<User> users = userService.getAllUsers();
        for (int i = 0; i <users.size() ; i++) {
            users.get(i).setFullName(users.get(i).getId()+"."+users.get(i).getLastName()+" "+users.get(i).getFirstName());
        }
        return users;
    }

    @RequestMapping("/article/{id}/details")
    public ModelAndView showDetails(@PathVariable("id") int articleId){
        ModelAndView mv = new ModelAndView("article_details");
        mv.addObject("title","Article Details");
        Article article = articleService.getArticle(articleId);
        User user = article.getUser();
        user.setFullName(user.getLastName() + " " + user.getFirstName());
        article.setUser(user);
        List<Thumbnail> thumbnails = thumbnailService.getThumbnailsByArticle(articleId);
        mv.addObject("thumbnails",thumbnails);
        mv.addObject("article",article);
        return mv;
    }

    @RequestMapping("/article/{articleId}/comments")
    @ResponseBody
    public List<Comment> getComments(@PathVariable int articleId){
        return commentService.getCommentsByArticle(articleId);
    }

    @ModelAttribute("user")
    public User getUser(){
        return new User();
    }

    @ModelAttribute("subjects")
    public List<Subject> getSubjects(){
        return subjectService.getAllSubjecs();
    }

    @ModelAttribute("subject")
    public Subject getSubject(){
        return new Subject();
    }


}
