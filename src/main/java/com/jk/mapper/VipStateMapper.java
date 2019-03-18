package com.jk.mapper;

import com.jk.bean.Vip;
import com.jk.bean.VipState;

import java.util.List;

public interface VipStateMapper {


    List<VipState> queryVipStart(long time);


    Vip queryVipById(Integer userid);


    void upVipState(Integer id);

    void queryVipByTime(long time);

    VipState queryVipStartByid(Integer userid);


    void upVip(VipState vipState);

    void addVipState(VipState vipState);

    void jianMoney(VipState vipState);
}
