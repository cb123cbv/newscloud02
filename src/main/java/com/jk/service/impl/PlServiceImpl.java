package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.github.pagehelper.PageHelper;
import com.jk.bean.Common;
import com.jk.bean.Huifu;
import com.jk.bean.Pl;
import com.jk.mapper.PlMapper;
import com.jk.service.PlService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class PlServiceImpl implements PlService {
 @Resource
 PlMapper plMapper;
 @Override
 public void addPl(Pl pl) {
  plMapper.addPl(pl);
 }

 @Override
 public SendPage queryPl(ReceivePage rp,Pl pl) {
  List<Pl> count=plMapper.queryPl(pl);
  PageHelper.startPage(rp.getPage(),rp.getRows());
  List<Pl> list=plMapper.queryPl(pl);
  SendPage sp=new SendPage(count.size(),list);
  return sp;
 }

 @Override
 public void addHuiFu(Huifu huifu) {
  plMapper.addHuiFu(huifu);
 }

 @Override
 public List<Huifu> queryHuiFu(Huifu huifu) {
  return plMapper.queryHuiFu(huifu);
 }
}
