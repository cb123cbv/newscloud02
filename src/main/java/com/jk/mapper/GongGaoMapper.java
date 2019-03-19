package com.jk.mapper;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import org.apache.ibatis.annotations.Select;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
public interface GongGaoMapper {
 @Select("select * from t_putonggonfgao where status=1")
 GongGao getGongGao();
 @Select("select * from t_zhongdagonggao where status=1")
 GongGao getGGao();
 @Select("update t_zhongdagonggao set status=0")
 void updateGGao();
}
