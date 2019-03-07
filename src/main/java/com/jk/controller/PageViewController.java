package com.jk.controller;

import com.jk.service.PageService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
}
