package com.jk.controller;

import com.jk.bean.Vip;
import com.jk.service.FollowService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("follow")
public class FollowController {

    @Resource
    private FollowService followService;

    @RequestMapping("queryList")
    @ResponseBody
    public SendPage queryList(ReceivePage receivePage, Vip vip){
        SendPage list = followService.queryList(receivePage, vip);
        return list;
    }
}
