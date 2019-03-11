package com.jk.mapper;

import com.jk.bean.Guanzhu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonthGuanzhuMapper {
    List<Guanzhu> monthAttention();


    List<Guanzhu> getAuthorByVip(Integer id);

    void addGuanzhu(@Param("id") Integer id, @Param("auid") Integer auid);


    List<Integer> queryGuanZhuByVipId(Integer id);

    void removeGuanzhu(@Param("id") Integer id, @Param("auid") Integer auid);
}
