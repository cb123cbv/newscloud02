package com.jk.mapper;

import com.jk.bean.ImgInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImgMapper {
    @Select("select * from t_imgInfo")
    List<ImgInfo> queryImg();

    @Select("select * from t_imgInfo2")
    List<ImgInfo> queryImg2();
}
