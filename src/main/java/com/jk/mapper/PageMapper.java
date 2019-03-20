package com.jk.mapper;

import com.jk.bean.Common;
import com.jk.bean.Jifen;
import com.jk.bean.PageView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper {
    List<PageView> getPageList(@Param("tablename") String tablename);

    List<Common> queryTtph();

    Jifen queryJifen(Integer id);
}
