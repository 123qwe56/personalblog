package com.module.controller;

import com.module.entity.Blog;
import com.module.entity.blogUser;
import com.module.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/publishBlog")
    public String publishBlog(HttpServletRequest request, Model model){
        blogUser user = (blogUser) request.getSession().getAttribute("user");
        if (user == null) return "login";
        String author = user.getUsername();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String publish_time = sdf.format(date);
        String article_name = request.getParameter("article_name");
        String content = request.getParameter("content");
        Blog b = new Blog(author,article_name,content,publish_time);
        int i = blogService.publishNewBlog(b);
        if (i == 0) return "error";
        Collection<Blog> allBlog = blogService.findAllArticleName(author);
        model.addAttribute("allblog",allBlog);
        return "home";
    }

    @RequestMapping("/home")
    public String toHomePage(HttpServletRequest request,Model model){
        blogUser user = (blogUser) request.getSession().getAttribute("user");
        String author = user.getUsername();
        Collection<Blog> allBlog = blogService.findAllArticleName(author);
        model.addAttribute("allblog",allBlog);
        return "home";
    }

    @RequestMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") int id){
        blogService.deleteBlog(id);
        return "redirect:/home";
    }
}
