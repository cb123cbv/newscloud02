package com.jk.service;

import com.jk.bean.Common;
import com.jk.bean.LanMu;
import com.jk.bean.TuiJian;

import java.util.List;

public interface TuiJianService {
    void addTuiJian(TuiJian tuiJian);

    List<Common> queryYuleFive();

    List<Common> shenDuRead(Integer flag);

    List<Common> jingBaoNews(Integer flag);

    List<Common> blogRank(Integer flag);

    List<LanMu> queryLanmu(String tablename);
}
