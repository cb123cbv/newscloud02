package com.jk.service.impl;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;
import com.jk.mapper.PayMapper;
import com.jk.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

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
}
