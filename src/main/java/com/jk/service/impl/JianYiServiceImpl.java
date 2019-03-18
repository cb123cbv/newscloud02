package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.JIanYi;
import com.jk.mapper.JianYiMapper;
import com.jk.mapper.PlMapper;
import com.jk.service.JianYiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class JianYiServiceImpl implements JianYiService {
 @Resource
 JianYiMapper jianYiMapper;
 @Resource
 PlMapper plMapper;

 @Override
 public String addJIanYi(JIanYi j) {
  List<String> list=plMapper.queryMinGanCi();
  boolean type=false;
  for (String s : list) {
   if(j.getText().contains(s)){
    type=true;
    break;
   }
  }
  if(type){
   return "3";
  }else{
   jianYiMapper.addJIanYi(j);
   return "1";
  }
 }
}
