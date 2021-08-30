package com.example.myblog.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("loginuser")==null) {//拦截条件，session中“loginuser”不存在
            request.getRequestDispatcher("/index.html").forward(request, response);//重定向至登录页面
            return false;//不在进行下一步访问
        }else{
            return true;//有session放行
        }
    }
}
