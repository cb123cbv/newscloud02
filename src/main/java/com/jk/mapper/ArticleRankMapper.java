package com.jk.mapper;

import com.jk.bean.Common;
import com.jk.bean.PageView;
import com.jk.bean.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleRankMapper {


    void addArticle(PageView pageView);

    List<PageView> queryArticleList(@Param("queryParam") QueryParam queryParam);

    Common queryTitleName(@Param("titleid") Integer titleid,@Param("tablename")String tablename);
}
