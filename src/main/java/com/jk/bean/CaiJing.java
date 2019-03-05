package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CaiJing {

   private Integer  id;
   private String  title;
   private String  author;
   private Date time;
   private String  imgtype;
   private Integer  status;
   private Integer  userid;
}
