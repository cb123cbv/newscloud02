package com.jk.mapper;


import com.jk.bean.Common;
import com.jk.bean.TitleInfo;
import com.jk.bean.Vip;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TitleMapper {


    List<Common> queryList(@Param("common") Common common, @Param("name") String name);


    Common toTitleInfo(@Param("id") String id, @Param("name") String name);

    Vip queryUser(Integer userid);

    @Select("select vipname from t_vip where id = #{vipid}")
    String queryAuthorName(Integer vipid);

    @Select("select * from t_titleInfo")
    List<TitleInfo> queryTitle();
}
