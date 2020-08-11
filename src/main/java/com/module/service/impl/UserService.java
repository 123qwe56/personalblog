package com.module.service.impl;

import com.module.entity.Blog;
import com.module.entity.blogUser;
import com.module.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements com.module.service.UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Collection<blogUser> findAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Blog findBlog(int id) {
        return userMapper.findBlogByName(id);
    }

    @Override
    public int edit(Blog blog) {
        return userMapper.editBlogById(blog);
    }
}
