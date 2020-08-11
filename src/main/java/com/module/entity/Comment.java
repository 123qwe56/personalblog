package com.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    /*评论id*/
    private int id;

    /*评论人*/
    private String name;

    /*评论内容*/
    private String content1;

    /*评论时间*/
    private String comment_time;
}
