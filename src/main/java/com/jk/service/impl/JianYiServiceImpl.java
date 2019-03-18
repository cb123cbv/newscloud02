package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.JIanYi;
import com.jk.mapper.JianYiMapper;
import com.jk.service.JianYiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class JianYiServiceImpl implements JianYiService {
 @Resource
 JianYiMapper jianYiMapper;

 @Override
 public void addJIanYi(JIanYi j) {
  jianYiMapper.addJIanYi(j);
 }
}
