package com.module.controller;

import com.module.entity.blogUser;
import com.module.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/registerJump")
    public String JumpLogin(){
        return "register";
    }

    @RequestMapping("/register")
    public String Register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        blogUser blogUser = new blogUser(username,password,email);
        int i = registerService.registerNewUser(blogUser);
        if (i == 0) return "register";
        else return "login";
    }
}
