package com.jk.mapper;

import com.jk.bean.Huifu;
import com.jk.bean.Pl;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface PlMapper {
 void addPl(Pl pl);

 List<Pl> queryPl(Pl pl);

 void addHuiFu(Huifu huifu);

 List<Huifu> queryHuiFu(Huifu huifu);

    void addpinglunState(Pl pl);
}
