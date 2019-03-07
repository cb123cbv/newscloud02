package com.jk.service;

import com.jk.bean.PageView;
import com.jk.bean.QueryParam;

import java.util.List;

public interface ArticleRankService {

    void addArticle(PageView pageView);

    List<PageView> queryArticleList(QueryParam queryParam);
}
