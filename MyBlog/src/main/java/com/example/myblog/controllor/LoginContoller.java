package com.example.myblog.controllor;

import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;


import java.util.Date;

import static org.thymeleaf.util.StringUtils.*;

@Controller
public class LoginContoller {
    @Autowired
     private UserService userService;
    //登录
    @RequestMapping("/user/login")//登录请求
    public String login(@RequestParam() String username, //接受输入的用户名
                        @RequestParam() String password, //接受输入的密码
                        Model model, //向前端返回参数
                        HttpSession session){//设置session
        if(!isEmpty(username) && !isEmpty(password)){
            if(userService.usercheck(username,password)!=null){
                session.setAttribute("loginuser",username);
                return "redirect:/main.html";
            }else{
                model.addAttribute("msg","用户名或者密码错误");
                return "redirect:/index.html";
            }
        }else{
            model.addAttribute("msg","用户名密码不能为空");
            return "redirect:/index.html";
        }
    }
    //退出登录
    @GetMapping("/user/loginout")//登出请求
    public String loginout(HttpSession session){
        Date date=new Date();
        String username= (String) session.getAttribute("loginuser");
        userService.gettime(date,username);
        session.removeAttribute("loginuser");//清除session
        return "index.html";
    }
}
