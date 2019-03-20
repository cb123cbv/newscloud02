package com.jk.service;

import com.jk.bean.Common;
import com.jk.bean.Jifen;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface PageService {
    SendPage getDjl(ReceivePage ReceivePage,String  tablename);

    List<Common> queryTtph();

    Jifen queryJifen(Integer id);
}
