package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Huifu;
import com.jk.bean.Pl;
import com.jk.service.PlService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class PlController {
 @Resource
 PlService plService;
 @RequestMapping("addPl")
 public void addPl(Pl pl){

  plService.addPl(pl);
  plService.addpinglunState(pl);
 }
 @RequestMapping("queryPl")
 public SendPage queryPl(ReceivePage rp,Pl pl){
  return plService.queryPl(rp,pl);
 }
 @RequestMapping("addHuiFu")
 public void addHuiFu(Huifu huifu){
   plService.addHuiFu(huifu);
 }
 @RequestMapping("queryHuiFu")
 public List<Huifu> queryHuiFu(Huifu huifu){
   return plService.queryHuiFu(huifu);
 }

}
