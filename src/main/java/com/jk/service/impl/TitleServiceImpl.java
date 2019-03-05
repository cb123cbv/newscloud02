package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
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
    public List<XingZuo> queryXingZuo(XingZuo xingZuo) {
        return titleMapper.queryXingZuo(xingZuo);
    }

    @Override
    public List<YuEr> queryYuEr(YuEr yuEr) {
        return titleMapper.queryYuEr(yuEr);
    }

    @Override
    public SendPage queryYuLe(ReceivePage receivePage, YuLe yuLe) {
        List<YuLe> count = titleMapper.queryYuLe(yuLe);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<YuLe> list = titleMapper.queryYuLe(yuLe);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public SendPage queryTiYu(ReceivePage receivePage, TiYu tiYu) {
        List<TiYu> count = titleMapper.queryTiYu(tiYu);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<TiYu> list = titleMapper.queryTiYu(tiYu);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public SendPage queryCaiJing(ReceivePage receivePage, CaiJing caiJing) {
        List<CaiJing> count = titleMapper.queryCaiJing(caiJing);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<CaiJing> list = titleMapper.queryCaiJing(caiJing);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }


}
