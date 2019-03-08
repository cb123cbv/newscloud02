package com.jk.controller;


import com.jk.bean.Common;
import com.jk.bean.PageView;
import com.jk.bean.QueryParam;
import com.jk.bean.Vip;
import com.jk.service.ArticleRankService;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("title")
public class TitleController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private ArticleRankService articleRankService;


    @ResponseBody
    @RequestMapping("queryList")
    public SendPage queryList(ReceivePage receivePage, Common common,String name){
        if(name==null&&name==""){
            name="t_yule";
        }
        SendPage list = titleService.queryList(receivePage,common,name);
        return list;
    }

    @ResponseBody
    @RequestMapping("toTitleInfo")
    public QueryParam toTitleInfo(String id, String name, HttpSession session){
        QueryParam queryParam = titleService.toTitleInfo(id, name);

        Vip vip = (Vip) session.getAttribute("user");
        PageView pageView = new PageView();
        if(vip!=null){
            pageView.setUserid(vip.getId());
        }
        if(vip==null){
            pageView.setUserid(0);
        }
        pageView.setTitleid(queryParam.getCommon().getId());
        pageView.setTablename(queryParam.getCommon().getTablename());
        pageView.setVipid(queryParam.getVip().getId());
        articleRankService.addArticle(pageView);

        return queryParam;
    }



    @RequestMapping("toshowInfo")
    public String toTitleInfo(String id, String name, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "showInfo";
    }


}
