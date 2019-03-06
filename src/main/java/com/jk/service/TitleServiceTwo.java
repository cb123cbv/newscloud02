package com.jk.service;


import com.jk.bean.Common;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;


public interface TitleServiceTwo {


    SendPage queryList(ReceivePage receivePage, Common common, String name);


}
