package com.module.mapper;

import com.module.entity.blogUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {

    @Insert("insert into bloguser(username,password,email) values(#{username},#{password}," +
            "#{email})")
    int CreateNewUser(blogUser b);
}
