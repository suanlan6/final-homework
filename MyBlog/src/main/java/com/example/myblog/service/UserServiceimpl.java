package com.example.myblog.service;

import com.example.myblog.mapper.UserMapper;
import com.example.myblog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
//用户 service层实现
@Service
public class UserServiceimpl implements UserService{
    //自动装配usermapper
    @Autowired
    private UserMapper userMapper;
    //通过用户名密码在数据库中查找用户
    @Override
    public User usercheck(String username, String password) {//查找用户是否是已经注册用户
        return userMapper.getbynameandpassword(username,password);
    }
    //注册用户
    @Override
    public void register(String username, String password, String Email, Date registertime,Date lastonlinetime) {//注册用户
        userMapper.insertusers(username,password,Email,registertime,lastonlinetime);
    }
    //检验用户名
    @Override
    public Object usernamecheck(String username) {//查找用户名是否重复
        return userMapper.getbyusername(username);
    }
    //更新当前时间
    @Override
    public void gettime(Date date,String username) {
        userMapper.getthetime(date,username);
    }
    //通过用户名获取用户信息
    @Override
    public User getinfo(String username) {
        return userMapper.getallinfo(username);
    }
}
