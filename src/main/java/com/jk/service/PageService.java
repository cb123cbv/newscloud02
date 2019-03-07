package com.jk.service;

import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface PageService {
    SendPage getDjl(ReceivePage ReceivePage,String  tablename);
}
