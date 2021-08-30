package com.example.myblog.service;

import com.example.myblog.mapper.BlogMapper;
import com.example.myblog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//blog service实现
@Service
public class BlogServiceimpl implements BlogService{
    @Autowired
    BlogMapper blogMapper;
    //查找所有博客
    @Override
    public List<Blog> showallblog() {
        return (List<Blog>) blogMapper.showallblog();
    }
    //添加博客
    @Override
    public void addblog(String title, String text, String author, Date createtime, Date updatetime) {
        blogMapper.createnewblog(title,text,author,createtime,updatetime);
    }
    //通过输入名查找近似博客
    @Override
    public List<Blog> getbyname(String title) {
        return (List<Blog>) blogMapper.getbyblogname("%"+title+"%");
    }
    //通过标题找到博客
    @Override
    public Blog findblog(String title) {
        return blogMapper.findblogbytitle(title);
    }
    //通过id找到博客
    @Override
    public Blog findid(int id) {
        return blogMapper.findblogbyid(id);
    }
    //更改博客标题
    @Override
    public void updatetitle(String title, int id,Date date) {
        blogMapper.updateblogtitle(title,id,date);
    }
    //更改博客正文
    @Override
    public void updatetext(String text, int id,Date date) {
        blogMapper.updateblogtext(text,id,date);
    }
    //删除博客
    @Override
    public void deleteblog(int id) {
        blogMapper.deleteblog(id);
    }
}
