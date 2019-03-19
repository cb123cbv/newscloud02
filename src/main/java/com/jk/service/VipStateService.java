package com.jk.service;

import com.jk.bean.Vip;
import com.jk.bean.VipState;

import java.util.List;

public interface VipStateService {

    List<VipState> queryVipStart();

    Vip queryVipById(Integer userid);

    void upVipState(Integer id);

    void queryVipByTime();

    void addVipState(VipState vipState);

    void jianMoney(VipState vipState);
}
