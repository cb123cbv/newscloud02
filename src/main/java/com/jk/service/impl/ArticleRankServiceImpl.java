package com.jk.service.impl;

import com.jk.bean.Common;
import com.jk.bean.PageView;
import com.jk.bean.QueryParam;
import com.jk.mapper.ArticleRankMapper;
import com.jk.service.ArticleRankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleRankServiceImpl implements ArticleRankService {

    @Resource
    private ArticleRankMapper articleRankMapper;

    @Override
    public void addArticle(PageView pageView) {
        articleRankMapper.addArticle(pageView);
    }

    @Override
    public List<PageView> queryArticleList(QueryParam queryParam) {
        List<PageView> pageViews = articleRankMapper.queryArticleList(queryParam);
        for (PageView pageView : pageViews) {
            Common common=articleRankMapper.queryTitleName(pageView.getTitleid(),pageView.getTablename());
            pageView.setTitlename(common.getTitle());
            pageView.setTime(common.getTime());
        }
        return pageViews;
    }

}
