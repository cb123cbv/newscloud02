package com.jk.controller;

import com.jk.bean.Common;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("title")
public class TitleController {

    @Autowired
    private TitleService titleService;


    @ResponseBody
    @RequestMapping("queryList")
    public SendPage queryList(ReceivePage receivePage, Common common,String name){
        SendPage list = titleService.queryList(receivePage,common,name);
        return list;
    }




}
