package com.example.myblog.controllor;

import com.example.myblog.pojo.Blog;
import com.example.myblog.pojo.User;
import com.example.myblog.service.BlogService;
import com.example.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller

public class BlogController {
    @Autowired
    private BlogService blogService;//自动装配
    @Autowired
    private UserService userService;//自动装配
    //添加博客
    @RequestMapping("/blog/add")
    public String add(@RequestParam() String title, @RequestParam() String text, HttpSession session){//获取用户输入的用户名密码和session
        String name= (String) session.getAttribute("loginuser");//取出session中的用户名
        Date currenttime=new Date();//得到当前时间
        blogService.addblog(title,text,name,currenttime,currenttime);
        return "redirect:/main.html";
    }
    //显示所有博客
    @RequestMapping("/blog/allblog")
    @ResponseBody
    public List<Blog> alblog(){
        return blogService.showallblog();
    }//返回所有博客
    //删除博客
    @RequestMapping("/blog/delete/{id}")
    public String dropblog(@PathVariable() int id, Model model,HttpSession session){
        String name= (String) session.getAttribute("loginuser");//获取seesion
        User user= userService.getinfo(name);//获取当前用户
        String author=blogService.findid(id).getAuthor();//获取博客作者名字
        if(name.equals(author)||user.getPriority()==1){//判断请求删除者是否是该博客作者或者管理员
            blogService.deleteblog(id);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","超出访问权限");
            return "redirect:/main.html";
        }
    }
    //按照标题名字查找博客
    @RequestMapping("/blog/findtheorderblog")
    @ResponseBody
    public List<Blog> findtheorderblog(@RequestParam String name){
        return blogService.getbyname(name);//通过博客名搜索博客
    }
    //更改博客标题
    @RequestMapping("/blog/updatetitle/{id}")
    public String updateti(@PathVariable() int id,@RequestParam() String title, Model model,HttpSession session){
        String name= (String) session.getAttribute("loginuser");//获取当前用户名
        String author=blogService.findid(id).getAuthor();//获取作者名
        Date currenttime=new Date();//获取当前时间
        if(name.equals(author)){//判断是否为作者
            blogService.updatetitle(title,id,currenttime);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","超出访问权限");
            return "redirect:/main.html";
        }
    }
    //更改博客正文内容
    @RequestMapping("/blog/updatetext/{id}")
    public String updatete(@PathVariable() int id,@RequestParam() String text,Model model,HttpSession session){
        String name= (String) session.getAttribute("loginuser");//获取当前用户名
        String author=blogService.findid(id).getAuthor();//获取作者名
        System.out.println(author);
        Date currenttime=new Date();//获取当前时间
        if(name.equals(author)){//判断是否为作者
            blogService.updatetext(text,id,currenttime);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","超出访问权限");
            return "redirect:/main.html";
        }
    }
}
