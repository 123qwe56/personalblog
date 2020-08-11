package com.module.controller;

import com.module.entity.blogUser;
import com.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/dataVisualization")
    public String toDataVisualization(){
        return "data-visualization";
    }

    @RequestMapping("/maps")
    public String toMaps(){
        return "maps";
    }

    @RequestMapping("/manageUsers")
    public String toManageUsers(Model model){
        Collection<blogUser> allUsers = userService.findAllUsers();
        model.addAttribute("users",allUsers);
        return "manage-users";
    }

    @RequestMapping("/preferences")
    public String toPreferences(){
        return "preferences";
    }

    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin";
    }

}
