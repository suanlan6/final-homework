package com.example.myblog.service;

import com.example.myblog.pojo.User;

import java.util.Date;
//用户 service接口
public interface UserService {
    User usercheck(String username,String password);
    void register(String username, String password, String Email, Date registertime,Date lastonlinetime);
    Object usernamecheck(String username);
    void gettime(Date date,String username);
    User getinfo(String username);
}
