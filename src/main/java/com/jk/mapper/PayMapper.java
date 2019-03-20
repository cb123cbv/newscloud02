package com.jk.mapper;

import com.jk.bean.Jifen;
import org.apache.ibatis.annotations.Param;

public interface PayMapper {
    void addjifen(@Param("id") Integer id, @Param("qian") Integer qian);

    Jifen queryjifen(Integer id);

    void reduceYue(@Param("id")Integer id, @Param("yue") Integer yue, @Param("qian")Integer qian);

    void addYue(@Param("qian") Integer qian,@Param("id")Integer id);
}
