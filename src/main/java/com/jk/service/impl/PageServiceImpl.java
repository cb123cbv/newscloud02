package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Common;
import com.jk.bean.Jifen;
import com.jk.bean.PageView;
import com.jk.mapper.PageMapper;
import com.jk.service.PageService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Resource
    PageMapper PageMapper;
    @Override
    public SendPage getDjl(ReceivePage ReceivePage, String  tablename) {
        List<PageView> count = PageMapper.getPageList(tablename); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(ReceivePage.getPage(),ReceivePage.getRows());
        List<PageView> list = PageMapper.getPageList(tablename); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public  List<Common> queryTtph() {
        return   PageMapper.queryTtph();
    }

    @Override
    public Jifen queryJifen(Integer id) {

        return PageMapper.queryJifen(id);
    }
}
