package com.jk.controller;


import com.jk.bean.Common;
import com.jk.bean.Info;
import com.jk.bean.QueryParam;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        if(name==null){
            name="t_yule";
        }
        SendPage list = titleService.queryList(receivePage,common,name);
        return list;
    }

    @ResponseBody
    @RequestMapping("toTitleInfo")
    public QueryParam toTitleInfo(String id, String name){
        QueryParam queryParam = titleService.toTitleInfo(id, name);
        return queryParam;
    }



    @RequestMapping("toshowInfo")
    public String toTitleInfo(String id, String name, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "showInfo";
    }


}
