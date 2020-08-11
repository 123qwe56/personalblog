package com.module.mapper;

import com.module.entity.blogUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    @Select("select * from bloguser where username = #{username}")
    blogUser findUserByUsername(String username);

}
