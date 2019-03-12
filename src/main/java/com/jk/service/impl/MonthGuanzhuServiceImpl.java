package com.jk.service.impl;

import com.jk.bean.Guanzhu;
import com.jk.bean.Vip;
import com.jk.mapper.MonthGuanzhuMapper;
import com.jk.service.MonthGuanzhuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonthGuanzhuServiceImpl implements MonthGuanzhuService {

    @Resource
    MonthGuanzhuMapper monthGuanzhuMapper;

    @Override
    public List<Guanzhu> monthAttention() {
        return monthGuanzhuMapper.monthAttention();
    }

    @Override
    public List<Guanzhu> getAuthorByVip(Vip user) {
        return monthGuanzhuMapper.getAuthorByVip(user.getId());
    }

    @Override
    public void addGuanzhu(Vip user, Integer auid) {
        monthGuanzhuMapper.addGuanzhu(user.getId(),auid);
    }

    @Override
    public List<Integer> queryGuanZhuByVipId(Integer id) {
        return monthGuanzhuMapper.queryGuanZhuByVipId(id);
    }

    @Override
    public void removeGuanzhu(Integer id, Integer auid) {
        monthGuanzhuMapper.removeGuanzhu(id,auid);
    }

}
