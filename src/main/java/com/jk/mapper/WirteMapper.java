package com.jk.mapper;

import com.jk.bean.Common;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WirteMapper {



    List<Common> queryBiaoQian();

    @Select("select * from t_biaoqian where name=#{s}")
    Common queryBiaoQianByname(String s);

    void addqianbianByName(Common common);

    void addwrite(Common common);

    void addqianbianWirte(@Param("biaoqianid") Integer id, @Param("titleid")Integer titleid, @Param("selectName")String selectName);
}
