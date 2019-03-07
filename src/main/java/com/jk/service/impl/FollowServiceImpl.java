package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Vip;
import com.jk.mapper.FollowMapper;
import com.jk.service.FollowService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Resource
    private FollowMapper followMapper;

    @Override
    public SendPage queryList(ReceivePage receivePage, Vip vip) {
        List<Vip> count = followMapper.queryList(vip);
        PageHelper.startPage(receivePage.getPage(), receivePage.getRows());
        List<Vip> list = followMapper.queryList(vip);
        SendPage sp = new SendPage(count.size(), list);
        return sp;
    }
}
