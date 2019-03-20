package com.jk.service;


import com.jk.bean.*;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;


public interface TitleService {


    SendPage queryList(ReceivePage receivePage, Common common, String name);


    QueryParam toTitleInfo(String id, String name);


    List<TitleInfo> queryTitle();

    Common queryTitleOne(String id, String name);



    PayArticle queryPayArticle(PayArticle payArticle);

    Jifen queryjifen(Integer id);

    void jianJiFen(PayArticle article);

    void addPayArticle(PayArticle article);
}
