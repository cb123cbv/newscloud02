package com.jk.mapper;

import com.jk.bean.Common;
import com.jk.bean.LanMu;
import com.jk.bean.TuiJian;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuiJianMapper {
    void addTuiJian(TuiJian tuiJian);

    List<Common> queryYuleFive();

    List<Common> shenDuRead(Integer flag);

    List<Common> jingBaoNews(Integer flag);

    List<Common> blogRank(Integer flag);

    List<LanMu> queryLanmu(@Param("tablename") String tablename);
}
