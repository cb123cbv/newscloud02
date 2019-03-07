package com.jk.service;

import com.jk.bean.Vip;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface FollowService {

    SendPage queryList(ReceivePage receivePage, Vip vip);

}
