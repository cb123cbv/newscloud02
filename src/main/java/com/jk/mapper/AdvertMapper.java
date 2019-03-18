package com.jk.mapper;

import com.jk.bean.Advert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdvertMapper {

    @Select("select * from t_advert where id = #{id}")
    List<Advert> getAdvert(Integer id);
}
