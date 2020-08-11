package com.module.mapper;

import com.module.entity.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface BlogMapper {

    @Insert("insert into blog(author,article_name,content,publish_time) values" +
            "(#{author},#{article_name},#{content},#{publish_time})")
    int publishBlog(Blog blog);


    @Select("select article_name,id from blog where author=#{author}")
    Collection<Blog> findBlogNameAndId(String author);

    @Delete("delete from blog where id=#{id}")
    void deleteBlogByName(int id);
}
