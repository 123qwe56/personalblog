package com.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class blogUser {

    /*用户id*/
    private int id;

    /*用户名*/
    private String username;

    /*密码*/
    private String password;

    /*邮箱*/
    private String email;

    /*博客*/
    private Blog blog;

    public blogUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public blogUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public blogUser(int id, String username, String email, Blog blog) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.blog = blog;
    }
}
