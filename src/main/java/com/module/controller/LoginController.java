package com.module.controller;

import com.module.entity.blogUser;
import com.module.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginJump")
    public String JumpLogin(){
        return "login";
    }


    @RequestMapping("/index")
    public String JumpIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String Login(blogUser b, HttpServletRequest request, HttpServletResponse response){
        if (b.getUsername().equals("630236902") && b.getPassword().equals("yhy417")){
            return "admin";
        }
        blogUser user = loginService.findUser(b.getUsername());
        if (user != null) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60*4);
            session.setAttribute("user",user);
            return "index";
        }
        else return "register";
    }

    @RequestMapping("/blogStart")
    public String StartBlog(){
        return "blog";
    }
}
