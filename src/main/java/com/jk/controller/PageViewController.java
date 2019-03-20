package com.jk.controller;

import com.jk.bean.Common;
import com.jk.service.PageService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageViewController {
   @Resource
   private PageService PageService;

    @ResponseBody
    @RequestMapping("getDjl")
    public SendPage getDjl(ReceivePage ReceivePage,String tablename){
        SendPage  list=  PageService.getDjl(ReceivePage,tablename);
        return list;
    }
    //根据点击量对title进行排行
    @ResponseBody
    @RequestMapping("queryTtph")
    public List<Common> queryTtph(){

        return  PageService.queryTtph();
    }
}
