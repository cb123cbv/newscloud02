package com.jk.service;

import com.jk.bean.PingLun_State;

import java.util.List;

public interface PinglunStateService {
    Integer pingLunCount(Integer id);

    List<PingLun_State> querypingLunList(Integer id);

    void deletes(String substring);
}
