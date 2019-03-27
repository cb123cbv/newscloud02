package com.jk.mapper;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;
import org.apache.ibatis.annotations.Param;

public interface PayMapper {
    void addjifen(@Param("id") Integer id, @Param("qian") Double qian);

    Jifen queryjifen(Integer id);

    void reduceYue(@Param("id")Integer id, @Param("yue") Double yue, @Param("qian")Double qian);

    void addYue(@Param("qian") Double qian,@Param("id")Integer id);

    Integer getPwdcountByUserId(Integer id);

    void updateCount(Integer id);

    Vip queryByUserIdAndPaypwd(@Param("account") String account, @Param("r")String r);

    void updateCountToNormal(Integer id);
}
