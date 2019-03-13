package com.jk.mapper;

import com.jk.bean.Vip;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VipMapper {

    @Select("select * from t_vip")
    List<Vip> getAllBoZhu();
}
