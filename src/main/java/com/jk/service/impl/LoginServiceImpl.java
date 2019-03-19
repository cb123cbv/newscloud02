package com.jk.service.impl;

import com.jk.bean.Vip;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper LoginMapper;
    @Override
    public Vip getLogin(Vip vip) {

        return LoginMapper.getLogin(vip);
    }

    @Override
    public Vip getUserByQQ(Vip vip) {

        return  LoginMapper.getUserByQQ(vip);
    }
}
