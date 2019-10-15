package com.teacher.uz.my.controllers;

import com.teacher.uz.my.domains.Category;
import com.teacher.uz.my.domains.Skill;
import com.teacher.uz.my.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shoh Jahon on 10.05.2018.
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView showManageCategories(){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCategoryList",true);
        mv.addObject("title", "Cateogory");
        return mv;
    }

    @RequestMapping(value = "/create/category",method = RequestMethod.GET)
    public ModelAndView showCreateCategory(){
        ModelAndView mv = new ModelAndView("dashboard");
        Category category = new Category();
        mv.addObject("title","Category");
        mv.addObject("category",category);
        mv.addObject("userClickCreateCategory",true);
        return mv;
    }

    @RequestMapping(value = "/create/{id}/category",method = RequestMethod.GET)
    public ModelAndView showUpdateCategory(@PathVariable int id){
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("userClickCreateCategory",true);
        mv.addObject("title","Update Category");
        Category category = categoryService.getCategory(id);
        mv.addObject("category",category);
        return mv;
    }
    @RequestMapping(value = "/create/category", method = RequestMethod.POST)
    public String showCreateCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/category/categories";
    }

    @RequestMapping(value = "/delete/{id}/category", method = RequestMethod.POST)
    @ResponseBody
    public String handleCategorydDeletion(@PathVariable int id){
        categoryService.delelteCategory(id);
        return "You have successfully removed this category!";
    }
}
