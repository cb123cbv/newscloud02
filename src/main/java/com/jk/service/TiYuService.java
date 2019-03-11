package com.jk.service;

import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;

import java.util.List;

public interface TiYuService {

    List<LanMuBiaoTi> getOne(String tablename);

    List<LanMuBiaoTi> getTwo(String tablename);

    List<LanMuBiaoTi> getThree(String tablename);

    List<LanMuBiaoTi> getFour(String tablename);

    List<LanMuBiaoTi> getFive(String tablename);

    List<LanMuBiaoTi> getSix(String tablename);

    List<TiYu> getTiYu(String tablename);
}
