package com.example.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//USER实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;//用id
    private String username;//用户名
    private String password;//用户密码
    private String Email;//用户邮箱
    private Date registertime;//用户注册时间
    private Date lastonlinetime;//用户上次在线时间
    private Integer priority;//用户权限：1为管理员 0为普通用户
}
