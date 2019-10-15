package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Article;
import com.teacher.uz.my.domains.Test;
import com.teacher.uz.my.domains.Thumbnail;
import com.teacher.uz.my.services.ArticleService;
import com.teacher.uz.my.services.ThumbnailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Shoh Jahon on 11.05.2018.
 */
@Controller
@RequestMapping("thumbnail")
public class ThumbnailController {
    @Autowired
    private ThumbnailService thumbnailService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/thumbnails", method = RequestMethod.GET)
    public ModelAndView showManageThumbnails(@RequestParam(required = false) Integer page){
        ModelAndView mv = new ModelAndView("dashboard");
        List<Thumbnail> thumbnails = thumbnailService.getAllThumbnails();
        PagedListHolder<Thumbnail> pagedListHolder = new PagedListHolder<>(thumbnails);
        pagedListHolder.setPageSize(5);
        mv.addObject("maxPages",pagedListHolder.getPageCount());
        if (page == null || page<1 ||page>pagedListHolder.getPageCount()) page=1;
        mv.addObject("page",page);

        if (page==null || page<1 ||page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            mv.addObject("thumbnails",pagedListHolder.getPageList());
        }else if (page<=pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page-1);
            mv.addObject("thumbnails",pagedListHolder);
        }

        mv.addObject("userClickThumbnailList",true);
        mv.addObject("title", "Thumbnail");
        return mv;
    }

    @RequestMapping(value = "/create/thumbnail",method = RequestMethod.GET)
    public ModelAndView showCreateThumbnail(){
        ModelAndView mv = new ModelAndView("dashboard");
        Thumbnail thumbnail = new Thumbnail();
        mv.addObject("title","Thumbnail");
        mv.addObject("thumbnail",thumbnail);
        mv.addObject("userClickCreateThumbnail",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/thumbnail",method = RequestMethod.GET)
    public ModelAndView showUpdateThumbnail(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateThumbnail",true);
        mv.addObject("title","Update Thumbnail");
        Thumbnail thumbnail = thumbnailService.getThumbnail(id);
        mv.addObject("thumbnail",thumbnail);
        return mv;
    }
    @RequestMapping(value = "/create/thumbnail", method = RequestMethod.POST)
    public String showCreateThumbnail(@ModelAttribute("thumbnail") Thumbnail thumbnail) throws IOException {
        thumbnailService.saveThumbnail(thumbnail);

        if (!thumbnail.getThumbnail().getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:\\Intellij\\Teacher.uz\\MyTeacher.Uz\\src\\main\\webapp\\resources\\thumbs\\", thumbnail.getFileName()) + ".jpg"));
            outputStream.write(thumbnail.getThumbnail().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        return "redirect:/thumbnail/thumbnails";
    }

    @RequestMapping(value = "/delete/{id}/thumbnail", method = RequestMethod.POST)
    @ResponseBody
    public String handleThumbnailDeletion(@PathVariable int id){
        thumbnailService.deleteThumbnail(id);
        return "You have successfully removed this thumbnail!";
    }

    @ModelAttribute("articles")
    @ResponseBody
    public List<Article> getArticles(){
        return articleService.getAllArticles();
    }

    @ModelAttribute("article")
    public Article getArticle(){
        return new Article();
    }

}
