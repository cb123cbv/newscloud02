package com.jk.service;

import com.jk.bean.JunShi;
import com.jk.bean.XingZuo;
import com.jk.bean.YuEr;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;


public interface TitleService {

    SendPage queryJunShi(ReceivePage receivePage,JunShi junShi);

    SendPage queryXingZuo(ReceivePage receivePage,XingZuo xingZuo);

    SendPage queryYuEr(ReceivePage receivePage,YuEr yuEr);
}
