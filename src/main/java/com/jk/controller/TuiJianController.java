package com.jk.controller;

import com.jk.bean.Common;
import com.jk.bean.LanMu;
import com.jk.bean.TuiJian;
import com.jk.bean.Vip;
import com.jk.service.TuiJianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("tui")
public class TuiJianController {
    @Resource
    private TuiJianService tuiJianService;

    //推荐文章
    @RequestMapping("addTuiJian")
    @ResponseBody
    public String addTuiJian(TuiJian tuiJian, HttpSession session){


        System.out.println(tuiJian);

        Vip vip = (Vip) session.getAttribute("user");
        if(vip==null){
            return "1";//未登录
        }
        tuiJian.setUserid(vip.getId());
        tuiJian.setTauthor(vip.getVipname());
        tuiJianService.addTuiJian(tuiJian);
        return "";
    }

    //查询5条展示 /tui/queryYuleFive
    @RequestMapping("queryYuleFive")
    @ResponseBody
    public List<Common> queryYuleFive(){
        List<Common> list = tuiJianService.queryYuleFive();
        return list;
    }

    //深度阅读 查询所有 /tui/shenDuRead?flag=7
    @RequestMapping("shenDuRead")
    @ResponseBody
    public List<Common> shenDuRead(Integer flag){
        List<Common> list = tuiJianService.shenDuRead(flag);
        return list;
    }

    //劲爆热点  flag=6
    @RequestMapping("jingBaoNews")
    @ResponseBody
    public List<Common> jingBaoNews(Integer flag){
        List<Common> list = tuiJianService.jingBaoNews(flag);
        return list;
    }

    // 本周 博文排行  flag=8
    @RequestMapping("blogRank")
    @ResponseBody
    public List<Common> blogRank(Integer flag){
        List<Common> list = tuiJianService.blogRank(flag);
        return list;
    }

    //栏目 queryLanmu
    @RequestMapping("queryLanmu")
    @ResponseBody
    public List<LanMu> queryLanmu(String tablename){
        List<LanMu> list = tuiJianService.queryLanmu(tablename);
        
        return list;
    }


}
