package com.jk.mapper;

import com.jk.bean.Common;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {


    List<Common> queryList(@Param("common") Common common,@Param("name") String name);
}
