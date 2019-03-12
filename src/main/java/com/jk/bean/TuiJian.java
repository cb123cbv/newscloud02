package com.jk.bean;

import lombok.Data;

import java.util.Date;


@Data
public class TuiJian {

    private Integer id;
    private String tname;
    private String tlink;
    private String tauthor;
    private String blogaddr;
    private Integer pindao;
    private Integer lanmu;
    private Integer state=0;
    private Date tuitime;
    private Integer userid;
}
