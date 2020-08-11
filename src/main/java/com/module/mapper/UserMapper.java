package com.module.mapper;

import com.module.entity.Blog;
import com.module.entity.blogUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface UserMapper {

    @Select("select u.id,u.username,u.email,b.article_name,b.publish_time from bloguser u,blog b " +
            "where u.username=b.author")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "blog.article_name", column = "article_name"),
            @Result(property = "blog.publish_time", column = "publish_time"),
    })
    Collection<blogUser> getAllUsers();

    @Delete("delete from bloguser where id=#{id}")
    int deleteUserById(int id);

    @Select("select id,article_name,content from blog where id=#{id}")
    Blog findBlogByName(int id);

    @Update("update blog set article_name=#{article_name},content=#{content},update_time=" +
            "#{update_time} where id = #{id}")
    int editBlogById(Blog blog);
}
