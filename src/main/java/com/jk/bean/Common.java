package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Common implements Serializable {

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

    private Integer jifen;//推荐文章的链接

    //-----------------新增微博
    private String name;//标题
    private String textName;//编辑器内容
    private String selectName;//下拉列表框
    private String biaoqian;//标签
    private Integer titleid;



    private String endTime;//定时时间
    private long timeDate=1;


    private String site;//定位的地址

    private String money;//钱
    private Integer month=0;//月
    private Integer paystate=0;//充余额
    private Integer flag;

}
