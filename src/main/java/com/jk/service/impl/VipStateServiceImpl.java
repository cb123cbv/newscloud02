package com.jk.service.impl;

import com.jk.bean.Vip;
import com.jk.bean.VipState;
import com.jk.mapper.VipStateMapper;
import com.jk.service.VipStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class VipStateServiceImpl implements VipStateService {


    @Resource
    VipStateMapper vipStateMapper;

    @Override
    public List<VipState> queryVipStart() {
        long time=0;
        Date date = new Date();
        time = date.getTime();
        time=time+432000000;
        return vipStateMapper.queryVipStart(time);
    }

    @Override
    public Vip queryVipById(Integer userid) {
        return vipStateMapper.queryVipById(userid);
    }

    @Override
    public void upVipState(Integer id) {
        vipStateMapper.upVipState(id);
    }

    @Override
    public void queryVipByTime() {
        Date date = new Date();
        long time = date.getTime();
       vipStateMapper.queryVipByTime(time);
    }

    @Override
    public void addVipState(VipState vipState) {
            Date date = new Date();
            long time = date.getTime();
            long yue=vipState.getYue();
            long ss=yue*30*24*60*60*1000;//一个月

        VipState vipState1=vipStateMapper.queryVipStartByid(vipState.getUserid());
        if (vipState1!=null) {
            if(vipState1.getEndTime()<=time){
                vipState1.setEndTime(ss+time);
                vipStateMapper.upVip(vipState1);
            }else{
                vipState1.setEndTime(vipState1.getEndTime()+ss);
                vipStateMapper.upVip(vipState1);
            }

        }else{
            vipState.setEndTime(ss+time);
            vipState.setStartTime(time);
            vipStateMapper.addVipState(vipState);

        }
    }

    @Override
    public void jianMoney(VipState vipState) {
        vipStateMapper.jianMoney(vipState);
    }
}
