package com.jk.service.impl;

import com.jk.bean.LanMuBiaoTi;
import com.jk.mapper.TiYuMapper;
import com.jk.service.TiYuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TiYuServiceImpl implements TiYuService {

    @Resource
    private TiYuMapper tiYuMapper;

    @Override
    public List<LanMuBiaoTi> getOne(String tablename) {
        return tiYuMapper.getOne(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getTwo(String tablename) {
        return tiYuMapper.getTwo(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getThree(String tablename) {
        return tiYuMapper.getThree(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getFour(String tablename) {
        return tiYuMapper.getFour(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getFive(String tablename) {
        return tiYuMapper.getFive(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getSix(String tablename) {
        return tiYuMapper.getSix(tablename);
    }
}
