package com.jk.service;

import com.jk.bean.JunShi;
import com.jk.bean.XingZuo;
import com.jk.bean.YuEr;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface TitleService {

    SendPage queryJunShi(ReceivePage receivePage,JunShi junShi);

    List<XingZuo> queryXingZuo(XingZuo xingZuo);

    List<YuEr> queryYuEr(YuEr yuEr);

}
