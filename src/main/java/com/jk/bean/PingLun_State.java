package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class PingLun_State {

    Integer id;
    Integer titleid;
    String tablename;
    Date time;
    Integer vipid;
    String info;
    Integer pluserid;


    //--------接收返回的参数
    String vipname;
    String vipheadimg;
    String title;

}
