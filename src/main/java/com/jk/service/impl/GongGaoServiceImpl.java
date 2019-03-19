package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import com.jk.mapper.GongGaoMapper;
import com.jk.service.GongGaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class GongGaoServiceImpl implements GongGaoService {
 @Resource
 GongGaoMapper gongGaoMapper;

 @Override
 public GongGao getGongGao() {
  return gongGaoMapper.getGongGao();
 }

 @Override
 public GongGao getGGao() {
  GongGao gg=gongGaoMapper.getGGao();
  SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  try {
   if(gg!=null) {
    long parse = sp.parse(gg.getStarttime()).getTime();
    long parse2 = sp.parse(gg.getEndtime()).getTime();
    long time = new Date().getTime();
    System.out.println(parse);
    System.out.println(parse2);
    System.out.println(time);
    boolean datetime = time >= parse && time <= parse2;
    if (!datetime) {
     gongGaoMapper.updateGGao();
    }
   }
  } catch (ParseException e) {
   e.printStackTrace();
  }

  return gg;
 }
}
