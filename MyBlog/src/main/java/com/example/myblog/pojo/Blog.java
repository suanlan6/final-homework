package com.example.myblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.Temporal;
import java.util.Date;
//实体层，在maven中引入lombok，自动补充getter，setter，有参、无参构造方法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;//博客id
    private String title;//博客标题
    private String author;//博客作者
    private String text;//博客正文
    private Date previewtime;//博客发表时间
    private Date updatetime;//博客更新时间
}
