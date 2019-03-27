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
    public void addjifen(Vip users, Double qian) {
        payMapper.addjifen(users.getId(),qian);
    }

    @Override
    public Jifen queryjifen(Vip users) {
        return payMapper.queryjifen(users.getId());
    }

    @Override
    public void yuePay(Vip users, Jifen jifen, Double qian) {

        //扣余额
        payMapper.reduceYue(users.getId(),jifen.getYue(),qian);

        //加积分
        payMapper.addjifen(users.getId(),qian);
    }

    @Override
    public void addYue(Vip users, Double qian) {

        //添加余额
        payMapper.addYue(qian,users.getId());
    }

    @Override
    public Integer getPwdcountByUserId(Integer id) {
        return payMapper.getPwdcountByUserId(id);
    }

    @Override
    public void updateCount(Integer id) {
        payMapper.updateCount(id);
    }

    @Override
    public Vip queryByUserIdAndPaypwd(String account, String r) {
        return payMapper.queryByUserIdAndPaypwd(account,r);
    }

    @Override
    public void updateCountToNormal(Integer id) {
        payMapper.updateCountToNormal(id);
    }


}
