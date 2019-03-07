package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Guanzhu {

   private Integer id;
   private Integer authorid;
   private Integer userid;
   private Date createtime;

   private Integer shuliang;
   private String auname;//作者名字
   private String imgurl;//作者头像

}
