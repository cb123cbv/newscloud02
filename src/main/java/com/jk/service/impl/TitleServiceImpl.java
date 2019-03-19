package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Common;
import com.jk.bean.Info;
import com.jk.bean.QueryParam;
import com.jk.bean.Vip;
import com.jk.client.MongodbClient;
import com.jk.bean.*;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService
{

    @Resource
    private TitleMapper titleMapper;
    @Autowired
    private MongodbClient mongodbClient;

    @Override
    public SendPage queryList(ReceivePage receivePage, Common common, String name) {
        List<Common> count = titleMapper.queryList(common, name);
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Common> list = titleMapper.queryList(common, name);
        for (Common common1 : list) {
           String authorName = titleMapper.queryAuthorName(common1.getVipid());
           common1.setVipname(authorName);
        }
        SendPage sp = new SendPage(count.size(), list);
        return sp;
    }

    @Override
    public QueryParam toTitleInfo(String id, String name) {
        Info info = mongodbClient.getInfoById(id, name);
        Common common = titleMapper.toTitleInfo(id, name);
        common.setImgtype(info.getInfo());
        Vip vip = titleMapper.queryUser(common.getVipid());
        QueryParam queryParam = new QueryParam();
        queryParam.setCommon(common);
        queryParam.setVip(vip);
        return queryParam;
    }

    @Override
    public List<TitleInfo> queryTitle() {
        return titleMapper.queryTitle();
    }


}
