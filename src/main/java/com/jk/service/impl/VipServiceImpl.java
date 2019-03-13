package com.jk.service.impl;

import com.jk.bean.Vip;
import com.jk.mapper.VipMapper;
import com.jk.service.VipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {

    @Resource
    private VipMapper vipMapper;

    @Override
    public List<Vip> getAllBoZhu() {
        return vipMapper.getAllBoZhu();
    }
}
