package com.jk.service.impl;


import com.jk.bean.Common;
import com.jk.bean.LanMu;
import com.jk.bean.TuiJian;
import com.jk.mapper.TuiJianMapper;
import com.jk.service.TuiJianService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TuiJianServiceImpl implements TuiJianService {
    @Resource
    private TuiJianMapper tuiJianMapper;

    @Override
    public void addTuiJian(TuiJian tuiJian) {

        tuiJianMapper.addTuiJian(tuiJian);
    }

    @Override
    public List<Common> queryYuleFive() {

        return tuiJianMapper.queryYuleFive();
    }

    @Override
    public List<Common> shenDuRead(Integer flag) {
        return tuiJianMapper.shenDuRead(flag);
    }

    @Override
    public List<Common> jingBaoNews(Integer flag) {
        return tuiJianMapper.jingBaoNews(flag);
    }

    @Override
    public List<Common> blogRank(Integer flag) {
        return tuiJianMapper.blogRank(flag);
    }

    @Override
    public List<LanMu> queryLanmu(String tablename) {
        return tuiJianMapper.queryLanmu(tablename);
    }




}
