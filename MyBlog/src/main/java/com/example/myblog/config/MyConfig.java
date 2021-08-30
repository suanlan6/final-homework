package com.example.myblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");//默认页面为登录页
        registry.addViewController("/index.html").setViewName("index");//设定index登录页面的url
        registry.addViewController("/register.html").setViewName("register");//设定register登录页面的url
        registry.addViewController("/main.html").setViewName("blogs");//设定用户界面由main.html跳转到blogs.html
    }

   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**")//拦截localhost8080下页面
        .excludePathPatterns("/index.html","/","/css/**","/js/**","/user/login","/user/register","/register.html");
        //不拦截localhost8080，以及主页面，登录请求，登出请求，注册请求，和静态资源
    }*/
}
