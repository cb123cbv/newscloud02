package com.jk.service.impl;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;
import com.jk.bean.VipState;
import com.jk.mapper.PayMapper;
import com.jk.mapper.VipStateMapper;
import com.jk.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Resource
    private VipStateMapper vipStateMapper;

    @Override
    public void addjifen(Vip users, Integer qian) {
        payMapper.addjifen(users.getId(),qian);
    }

    @Override
    public Jifen queryjifen(Vip users) {
        return payMapper.queryjifen(users.getId());
    }

    @Override
    public void yuePay(Vip users, Jifen jifen, Integer qian) {



        //扣余额
        payMapper.reduceYue(users.getId(),jifen.getYue(),qian);

        //加积分
        payMapper.addjifen(users.getId(),qian);
    }

    @Override
    public void addVip(Integer id, Integer zzz) {
        VipState vipState = new VipState();
        vipState.setUserid(id);
        vipState.setYue(zzz);
        vipStateMapper.addVipState(vipState);
    }
}
