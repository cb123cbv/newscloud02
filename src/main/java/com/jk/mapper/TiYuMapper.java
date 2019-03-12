package com.jk.mapper;

import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TiYuMapper {

    List<LanMuBiaoTi> getOne(@Param("tablename") String tablename);

    List<LanMuBiaoTi> getTwo(@Param("tablename") String tablename);

    List<LanMuBiaoTi> getThree(@Param("tablename") String tablename);

    List<LanMuBiaoTi> getFour(@Param("tablename") String tablename);

    List<LanMuBiaoTi> getFive(@Param("tablename") String tablename);

    List<LanMuBiaoTi> getSix(@Param("tablename") String tablename);

    List<TiYu> getTiYu(@Param("tablename") String tablename);
}
