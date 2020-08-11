package com.module.service;

import com.module.entity.Blog;

import java.util.Collection;


public interface BlogService {

    int publishNewBlog(Blog blog);

    Collection<Blog> findAllArticleName(String author);

    void deleteBlog(int id);
}
