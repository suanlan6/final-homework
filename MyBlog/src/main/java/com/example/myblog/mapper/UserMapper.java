package com.example.myblog.mapper;

import com.example.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
//user MAPPER层
@Mapper
@Repository
public interface UserMapper {
    //DAO层查找方法
    User getbynameandpassword(String username,String password);
    //DAO层插入方法
    Integer insertusers(String username, String password, String Email, Date registertime,Date lastonlinetime);
    //DAO层查找方法
    Object getbyusername(String username);
    //DAO层录入当前时间方法
    void getthetime(Date lastonlinetime,String username);
    //DAO层获取用户信息方法
    User getallinfo(String username);
}
