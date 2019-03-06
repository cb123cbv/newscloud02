package com.jk.controller;

import com.jk.bean.*;
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
//军事
    @ResponseBody
    @RequestMapping("queryJunShi")
    public SendPage queryJunShi(ReceivePage receivePage,JunShi junShi){
        SendPage list = titleService.queryJunShi(receivePage,junShi);
        return list;
    }
//星座
    @ResponseBody
    @RequestMapping("queryXingZuo")
    public SendPage queryXingZuo(ReceivePage receivePage,XingZuo xingZuo){
        SendPage list = titleService.queryXingZuo(receivePage,xingZuo);
        return list;
    }
//育儿
    @ResponseBody
    @RequestMapping("queryYuEr")
    public SendPage queryYuEr(ReceivePage receivePage,YuEr yuEr){
        SendPage list = titleService.queryYuEr(receivePage,yuEr);
        return list;
    }

//娱乐
    @ResponseBody
    @RequestMapping("queryYuLe")
    public SendPage queryYuLe(ReceivePage receivePage,YuLe yuLe){
        SendPage list = titleService.queryYuLe(receivePage,yuLe);
        return list;
    }

//体育
    @ResponseBody
    @RequestMapping("queryTiYu")
    public SendPage queryTiYu(ReceivePage receivePage,TiYu tiYu){
        SendPage list = titleService.queryTiYu(receivePage,tiYu);
        return list;
    }
//财经
    @ResponseBody
    @RequestMapping("queryCaiJing")
    public SendPage queryCaiJing(ReceivePage receivePage,CaiJing caiJing){
        SendPage list = titleService.queryCaiJing(receivePage,caiJing);
        return list;
    }
}
