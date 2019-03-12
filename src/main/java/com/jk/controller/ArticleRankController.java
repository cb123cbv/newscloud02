package com.jk.controller;

import com.jk.bean.PageView;
import com.jk.bean.QueryParam;
import com.jk.service.ArticleRankService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleRankController {


    @Resource
    private ArticleRankService articleRankService;

    @ResponseBody
    @RequestMapping("addArticle")
    public void addArticle(PageView pageView){
        articleRankService.addArticle(pageView);
    }

    @ResponseBody
    @RequestMapping("queryArticleList")
    public List<PageView> queryArticleList(QueryParam queryParam){
        if(queryParam.getFlag()==null){
            queryParam.setFlag(3);
        }
        List<PageView> pageViews=articleRankService.queryArticleList(queryParam);
        return pageViews;
    }









}
