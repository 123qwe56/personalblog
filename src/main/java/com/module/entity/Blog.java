package com.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    /*文章编号*/
    private int id;

    /*文章作者*/
    private String author;

    /*文章标题*/
    private String article_name;

    /*文章内容*/
    private String content;

    /*文章发布时间*/
    private String publish_time;

    /*文章修改时间*/
    private String update_time;

    /*文章评论*/
    private Comment comment;

    public Blog(String article_name, String publish_time) {
        this.article_name = article_name;
        this.publish_time = publish_time;
    }

    public Blog(String author, String article_name, String content, String publish_time) {
        this.author = author;
        this.article_name = article_name;
        this.content = content;
        this.publish_time = publish_time;
    }

    public Blog(int id, String article_name, String content, String update_time) {
        this.id = id;
        this.article_name = article_name;
        this.content = content;
        this.update_time = update_time;
    }

    public Blog(int id, String article_name, String content) {
        this.id = id;
        this.article_name = article_name;
        this.content = content;
    }

    public Blog(int id, String article_name) {
        this.id = id;
        this.article_name = article_name;
    }
}
