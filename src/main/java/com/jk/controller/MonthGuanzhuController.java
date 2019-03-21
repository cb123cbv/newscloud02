package com.jk.controller;

import com.jk.bean.Guanzhu;
import com.jk.bean.Vip;
import com.jk.service.MonthGuanzhuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("monthGuanzhu")
public class MonthGuanzhuController {

    @Resource
    private MonthGuanzhuService monthGuanzhuService;


    // 月关注榜
    @RequestMapping("monthRank")
    @ResponseBody
    public List<Guanzhu> monthAttention(HttpSession session) {
        Vip user = (Vip) session.getAttribute("user");
        List<Guanzhu> rankInfo = monthGuanzhuService.monthAttention();
        if (user == null) {//未登录 查询所有
            return rankInfo;
        }

        List<Integer> author = monthGuanzhuService.queryGuanZhuByVipId(user.getId());
        for (Guanzhu guanzhu : rankInfo) {
            if (author.contains(guanzhu.getAuthorid())) {
                guanzhu.setState(1);//已关注
            }else{
                guanzhu.setState(0);//未关注
            }
        }
        return rankInfo;
    }

    //加关注
    @RequestMapping("addGuanzhu")//登录后关注()   只能关注一次
    @ResponseBody
    public String addGuanzhu(HttpSession session, Integer auid) {

        Vip user = (Vip) session.getAttribute("user");
        System.out.println(user);
        if (user == null) {//未登录
            return "0";//0 请先登录   // 1关注成功 // 2 已经关注过 // 3不能自己关注自己
        }
        if(user.getId()==auid){
            return "3";//3不能自己关注自己
        }

        //当前用户关注的作者信息
        List<Guanzhu> list = monthGuanzhuService.getAuthorByVip(user);
        for (Guanzhu guanzhu : list) {
            if (guanzhu.getAuthorid()==auid) {
                return "2";//已经关注过
            }
        }
        monthGuanzhuService.addGuanzhu(user, auid);
        return "1";// 1关注成功
    }


   //取消关注
    @RequestMapping("removeGuanzhu")
    @ResponseBody
    public String removeGuanzhu(HttpSession session, Integer auid){
        Vip user = (Vip) session.getAttribute("user");
        monthGuanzhuService.removeGuanzhu(user.getId(),auid);
        return "";
    }

}
