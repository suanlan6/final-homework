package com.example.myblog.controllor;

import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import java.util.Date;

import static java.util.Objects.isNull;
import static org.thymeleaf.util.StringUtils.isEmpty;


@Controller
@Validated
public class RigsterController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user/register")//注册请求
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @Email(message = "邮箱格式错误") @RequestParam String  email,
                           Model model, HttpSession session){
        if(!isEmpty(username)&&!isEmpty(password)){
            if(userService.usernamecheck(username)!=null){//判断username是否与数据库表中已有用户重复
                model.addAttribute("用户名已注册！");
                return "redirect:/register.html";
            }else{
                Date currenttime=new Date();
                userService.register(username,password,email,currenttime,currenttime);//调用service层执行注册
                model.addAttribute("msg","注册成功！");
                return "redirect:/index.html";
            }
        }else{//不允许用户名和密码为空
            model.addAttribute("msg","用户名和密码不能为空！");
            return "redirect:/register.html";
        }
    }
}
