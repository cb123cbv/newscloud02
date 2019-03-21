package com.jk.controller;


import com.jk.bean.*;
import com.jk.service.ArticleRankService;
import com.jk.service.PinglunStateService;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("title")
public class TitleController {

   @Resource
    private TitleService titleService;

    @Resource
    private PinglunStateService pinglunStateService;

    @Resource
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



   /* @RequestMapping("toshowInfo2")
    public String toshowInfo2(String id, String name, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "showInfo";
    }*/


    //文章支付积分，跳转页面的
    @RequestMapping("toshowInfo")//需要当前对象
    public String toshowInfo(String id, String name, Model model,HttpSession session){

        Vip user = (Vip) session.getAttribute("user");
        Common common = titleService.queryTitleOne(id, name);
        model.addAttribute("jiage",common.getJifen());
        model.addAttribute("titleid",id);
        model.addAttribute("tablename",name);
        if (user==null) {
            return "tiaozhuan";
        }
        PayArticle payArticle = new PayArticle();
        payArticle.setUserid(user.getId());
        payArticle.setTablename(name);
        payArticle.setTitleid(id);
        PayArticle payArticle1 = titleService.queryPayArticle(payArticle);
        Jifen queryjifen = titleService.queryjifen(user.getId());//查询剩余积分
        if (payArticle1==null) {//支付状态
            model.addAttribute("payState",0);
        }else{
            model.addAttribute("payState",1);
        }
        model.addAttribute("vipid",user.getId());//用户剩余积分
        model.addAttribute("authorid",common.getVipid());
        model.addAttribute("vipjifen",queryjifen.getJifen());//用户剩余积分

        return "tiaozhuan";
    }

    @ResponseBody
    @RequestMapping("jianJiFen")//需要当前对象
    public String jianJiFen(PayArticle article,HttpSession session){
        Vip user = (Vip) session.getAttribute("user");
        article.setUserid(user.getId());
        titleService.jianJiFen(article);
        titleService.addPayArticle(article);
        return "1";
    }

    @ResponseBody
    @RequestMapping("deletePlState")
    public String deletePlState(String id){
        pinglunStateService.deletes(id);
        return "1";
    }

    //评论专用
    @RequestMapping("toshowInfo2")
    public String toTitleInfo3(String id, String name,String id2, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        pinglunStateService.deletes(id2);
        return "showInfo";
    }



    //导航栏
    @RequestMapping("queryTitle")
    @ResponseBody
    public List<TitleInfo> queryTitle(){
        List<TitleInfo> list = titleService.queryTitle();
        return list;
    }



}
