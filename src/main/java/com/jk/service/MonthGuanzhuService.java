package com.jk.service;

import com.jk.bean.Guanzhu;
import com.jk.bean.Vip;

import java.util.List;

public interface MonthGuanzhuService {

    List<Guanzhu> monthAttention();


    List<Guanzhu> getAuthorByVip(Vip user);

    void addGuanzhu(Vip user, Integer auid);

    List<Integer> queryGuanZhuByVipId(Integer id);

    void removeGuanzhu(Integer id, Integer auid);
}
