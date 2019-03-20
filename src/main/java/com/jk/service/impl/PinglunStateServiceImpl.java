package com.jk.service.impl;

import com.jk.bean.PingLun_State;
import com.jk.mapper.PinglunStateMapper;
import com.jk.service.PinglunStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PinglunStateServiceImpl implements PinglunStateService {

    @Resource
    private PinglunStateMapper pinglunStateMapper;

    @Override
    public Integer pingLunCount(Integer id) {
        return pinglunStateMapper.pingLunCount(id);
    }

    @Override
    public List<PingLun_State> querypingLunList(Integer id) {
        List<PingLun_State> list =pinglunStateMapper.querypingLunList(id);
        for (PingLun_State pingLun_state : list) {
            PingLun_State pingLun_state1 = pinglunStateMapper.queryTitleList(pingLun_state);
            pingLun_state.setTitle(pingLun_state1.getTitle());
        }
        List<PingLun_State> pingLun_states = pinglunStateMapper.querySystemInfo(id);
        list.addAll(pingLun_states);
        return list;
    }

    @Override
    public void deletes(String substring) {
        pinglunStateMapper.deletes(substring);
    }
}
