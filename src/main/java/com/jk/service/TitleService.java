package com.jk.service;


import com.jk.bean.Common;
import com.jk.bean.QueryParam;
import com.jk.bean.TitleInfo;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;


public interface TitleService {


    SendPage queryList(ReceivePage receivePage, Common common, String name);


    QueryParam toTitleInfo(String id, String name);


    List<TitleInfo> queryTitle();
}
