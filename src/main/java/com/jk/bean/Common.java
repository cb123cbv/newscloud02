package com.jk.bean;

import lombok.Data;

@Data
public class Common {

    private Integer id;

    private String title;

    private String ss;

    private Integer vipid;

    private String time;

    private String imgtype;

    private Integer status;

    private Integer userid;

    private String tablename;

    private String imgurl;

    private String vipname;
    Integer djl;//数量
    private String tlink;//推荐文章的链接

    //-----------------新增微博
    private String name;
    private String textName;
    private String selectName;
    private String biaoqian;
    private Integer titleid;



    private String endTime;
    private long timeDate=1;





}
