package com.module.controller;

import com.module.entity.Blog;
import com.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CRUDController {

    @Autowired
    private UserService userService;

    @RequestMapping("/editBlog/{id}")
    public String toEditBlogPage(@PathVariable("id") int id,
                                 Model model){
        Blog blog = userService.findBlog(id);
        model.addAttribute("blog",blog);
        return "editBlog";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return "redirect:/manageUsers";
    }

    @PostMapping("/editBlog")
    public String editBlog(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String update_time = sdf.format(date);
        String article_name = request.getParameter("article_name");
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        Blog blog = new Blog(id,article_name,content,update_time);
        userService.edit(blog);
        return "redirect:/home";
    }


}
