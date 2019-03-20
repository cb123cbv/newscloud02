package com.jk.service;

import com.jk.bean.Huifu;
import com.jk.bean.Pl;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface PlService {
 String addPl(Pl pl);

 SendPage queryPl(ReceivePage rp,Pl pl);

 String addHuiFu(Huifu huifu);

 List<Huifu> queryHuiFu(Huifu huifu);



}
