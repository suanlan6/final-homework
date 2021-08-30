package com.example.myblog.service;

import com.example.myblog.pojo.Blog;

import java.util.Date;
import java.util.List;
//blog service接口
public interface BlogService {
    List<Blog> showallblog();
    void addblog(String title, String text, String author, Date createtime, Date updatetime);
    Blog findblog(String title);
    Blog findid(int id);
    List<Blog> getbyname(String title);
    void deleteblog(int id);
    void updatetitle(String title,int id,Date date);
    void updatetext(String text,int id,Date date);
}
