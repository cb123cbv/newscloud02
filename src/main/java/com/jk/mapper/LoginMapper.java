package com.jk.mapper;

import com.jk.bean.Vip;

public interface LoginMapper {
    Vip getLogin(Vip vip);

    Vip getUserByQQ(Vip vip);

    Vip toLoginByQQ(Vip vip);
}
