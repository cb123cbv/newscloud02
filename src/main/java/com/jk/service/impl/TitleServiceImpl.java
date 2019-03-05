package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.JunShi;
import com.jk.bean.XingZuo;
import com.jk.bean.YuEr;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Resource
    private TitleMapper titleMapper;

    @Override
    public SendPage queryJunShi(ReceivePage receivePage,JunShi junShi) {
        List<JunShi> count = titleMapper.queryJunShi(junShi);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<JunShi> list = titleMapper.queryJunShi(junShi);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public SendPage queryXingZuo(ReceivePage receivePage,XingZuo xingZuo) {
        List<XingZuo> count = titleMapper.queryXingZuo(xingZuo);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<XingZuo> list = titleMapper.queryXingZuo(xingZuo);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public SendPage queryYuEr(ReceivePage receivePage,YuEr yuEr) {
        List<YuEr> count = titleMapper.queryYuEr(yuEr);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<YuEr> list = titleMapper.queryYuEr(yuEr);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

}
