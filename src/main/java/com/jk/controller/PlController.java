package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Huifu;
import com.jk.bean.Pl;
import com.jk.bean.Vip;
import com.jk.service.PlService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
 public String addPl(Pl pl,HttpSession session){
  Vip user = (Vip) session.getAttribute("user");
  if(user.getStatus()==0){
   return "2";
  }else{
   return plService.addPl(pl);
  }
 }
 @RequestMapping("queryPl")
 public SendPage queryPl(ReceivePage rp,Pl pl){
  return plService.queryPl(rp,pl);
 }
 @RequestMapping("addHuiFu")
 public String addHuiFu(Huifu huifu,HttpSession session){
  Vip user = (Vip) session.getAttribute("user");
  if(user.getStatus()==0){
   return "2";
  }else {
   return plService.addHuiFu(huifu);
  }
 }
 @RequestMapping("queryHuiFu")
 public List<Huifu> queryHuiFu(Huifu huifu){
   return plService.queryHuiFu(huifu);
 }

}
