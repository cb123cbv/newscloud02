package com.jk.mapper;

import com.jk.bean.JunShi;
import com.jk.bean.XingZuo;
import com.jk.bean.YuEr;

import java.util.List;

public interface TitleMapper {

    List<JunShi> queryJunShi(JunShi junShi);

    List<XingZuo> queryXingZuo(XingZuo xingZuo);

    List<YuEr> queryYuEr(YuEr yuEr);
}
