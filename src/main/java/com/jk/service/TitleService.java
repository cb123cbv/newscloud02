package com.jk.service;

import com.jk.bean.*;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface TitleService {

    SendPage queryJunShi(ReceivePage receivePage,JunShi junShi);

    SendPage queryXingZuo(ReceivePage receivePage,XingZuo xingZuo);




    SendPage queryYuLe(ReceivePage receivePage, YuLe yuLe);

    SendPage queryTiYu(ReceivePage receivePage, TiYu tiYu);

    SendPage queryCaiJing(ReceivePage receivePage, CaiJing caiJing);
    SendPage queryYuEr(ReceivePage receivePage,YuEr yuEr);
}
