package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Common;
import com.jk.bean.QueryParam;
import com.jk.bean.Vip;
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
    public SendPage queryList(ReceivePage receivePage, Common common, String name) {
        List<Common> count = titleMapper.queryList(common, name);
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Common> list = titleMapper.queryList(common, name);
        SendPage sp = new SendPage(count.size(), list);
        return sp;
    }

    @Override
    public QueryParam toTitleInfo(Integer id, String name) {

        Common common = titleMapper.toTitleInfo(id, name);
        Vip vip = titleMapper.queryUser(common.getUserid());
        QueryParam queryParam = new QueryParam();
        queryParam.setCommon(common);
        queryParam.setVip(vip);
        return queryParam;
    }


}
