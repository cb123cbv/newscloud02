package com.jk.mapper;

import com.jk.bean.*;

import java.util.List;

public interface TitleMapper {

    List<JunShi> queryJunShi(JunShi junShi);

    List<XingZuo> queryXingZuo(XingZuo xingZuo);

    List<YuEr> queryYuEr(YuEr yuEr);


    List<YuLe> queryYuLe(YuLe yuLe);

    List<TiYu> queryTiYu(TiYu tiYu);

    List<CaiJing> queryCaiJing(CaiJing caiJing);
}
