package com.jk.service;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;

public interface PayService {
    void addjifen(Vip users, Double qian);

    Jifen queryjifen(Vip users);

    void yuePay(Vip users, Jifen jifen, Double qian);


    void addYue(Vip users,Double qian);

    Integer getPwdcountByUserId(Integer id);

    void updateCount(Integer id);

    Vip queryByUserIdAndPaypwd(String account, String r);

    void updateCountToNormal(Integer id);
}
