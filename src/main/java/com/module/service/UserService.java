package com.module.service;

import com.module.entity.Blog;
import com.module.entity.blogUser;

import java.util.Collection;

public interface UserService {
    Collection<blogUser> findAllUsers();

    int deleteUser(int id);

    Blog findBlog(int id);

    int edit(Blog blog);
}
