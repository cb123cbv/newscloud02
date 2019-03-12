package com.jk.service;

import com.jk.bean.Common;

import java.util.List;

public interface WirteService {

    List<Common> queryBiaoQian();


    void addWrite(Common common);
}
