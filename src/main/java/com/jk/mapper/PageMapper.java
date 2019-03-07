package com.jk.mapper;

import com.jk.bean.PageView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper {
    List<PageView> getPageList(@Param("tablename") String tablename);
}
