package com.jk.service;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;

public interface PayService {
    void addjifen(Vip users, Integer qian);

    Jifen queryjifen(Vip users);

    void yuePay(Vip users, Jifen jifen, Integer qian);


}
