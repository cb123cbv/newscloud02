package com.jk.controller;

import com.jk.bean.JunShi;
import com.jk.bean.XingZuo;
import com.jk.bean.YuEr;
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
    @RequestMapping("queryJunShi")
    public SendPage queryJunShi(ReceivePage receivePage,JunShi junShi){
        SendPage list = titleService.queryJunShi(receivePage,junShi);
        return list;
    }

    @ResponseBody
    @RequestMapping("queryXingZuo")
    public SendPage queryXingZuo(ReceivePage receivePage,XingZuo xingZuo){
        SendPage list = titleService.queryXingZuo(receivePage,xingZuo);
        return list;
    }

    @ResponseBody
    @RequestMapping("queryYuEr")
    public SendPage queryYuEr(ReceivePage receivePage,YuEr yuEr){
        SendPage list = titleService.queryYuEr(receivePage,yuEr);
        return list;
    }

}
