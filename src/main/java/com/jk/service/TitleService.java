package com.jk.service;


import com.jk.bean.Common;
import com.jk.bean.QueryParam;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;


public interface TitleService {


    SendPage queryList(ReceivePage receivePage, Common common, String name);


    QueryParam toTitleInfo(Integer id, String name);


}
