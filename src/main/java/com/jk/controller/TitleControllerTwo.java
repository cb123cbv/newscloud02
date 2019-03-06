package com.jk.controller;


import com.jk.bean.Common;
import com.jk.service.TitleService;
import com.jk.service.TitleServiceTwo;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("title")
public class TitleControllerTwo {

    @Autowired
    private TitleServiceTwo titleServiceTwo;


    @ResponseBody
    @RequestMapping("queryList")
    public SendPage queryList(ReceivePage receivePage, Common common,String name){
        SendPage list = titleServiceTwo.queryList(receivePage,common,name);
        return list;
    }


}
