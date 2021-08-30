package com.example.myblog.mapper;

import com.example.myblog.pojo.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
//blog MAPPER层
@Mapper
@Repository
public interface BlogMapper {
    //显示所有博客
    List<Blog> showallblog();
    //添加博客
    void createnewblog(String title, String text, String author, Date createtime,Date updatetime);
    //找到相似查询的博客
    List<Blog> getbyblogname(String title);
    //通过标题找到博客
    Blog findblogbytitle(String title);
    //删除博客
    void deleteblog(int id);
    //通过id找到博客
    Blog findblogbyid(int id);
    //更改博客标题
    void updateblogtitle(String title,int id,Date date);
    //更改博客正文
    void updateblogtext(String text, int id,Date date);
}
