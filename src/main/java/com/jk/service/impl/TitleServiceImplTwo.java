package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Common;
import com.jk.mapper.TitleMapper;
import com.jk.mapper.TitleMapperTwo;
import com.jk.service.TitleService;
import com.jk.service.TitleServiceTwo;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImplTwo implements TitleServiceTwo {

    @Resource
    private TitleMapperTwo titleMapperTwo;


    @Override
    public SendPage queryList(ReceivePage receivePage, Common common, String name) {
        List<Common> count = titleMapperTwo.queryList(common, name);
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Common> list = titleMapperTwo.queryList(common, name);
        SendPage sp = new SendPage(count.size(), list);
        return sp;
    }


}
