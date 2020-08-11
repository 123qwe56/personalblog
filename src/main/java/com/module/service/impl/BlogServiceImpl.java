package com.module.service.impl;

import com.module.entity.Blog;
import com.module.mapper.BlogMapper;
import com.module.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int publishNewBlog(Blog blog) {
        return blogMapper.publishBlog(blog);
    }

    @Override
    public Collection<Blog> findAllArticleName(String author) {
        return blogMapper.findBlogNameAndId(author);
    }

    @Override
    public void deleteBlog(int id) {
        blogMapper.deleteBlogByName(id);
    }

}
