package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Vip implements Serializable {

    private Integer id;

    private String vipname;

    private String vipaccount;

    private String vippassword;

    private String vipheadimg;

    private Integer role;

    private Integer sl;

    private Integer authorid;
    private String phone;
    private Integer state=0;//1 已关注 0 未关注
    private String pinyiname;
    private Integer zt=0;
    Integer status;

    private String  opens;
}
