package com.jk.mapper;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.JIanYi;
import org.apache.ibatis.annotations.Insert;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
public interface JianYiMapper {
 @Insert("insert into t_jianyi(text,userid,status,datetime) value(#{text},#{userid},0,sysdate())")
 void addJIanYi(JIanYi j);
}
