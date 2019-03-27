package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Huifu;
import com.jk.bean.Pl;
import com.jk.bean.Vip;
import com.jk.bean.VipState;
import com.jk.service.PlService;
import com.jk.utils.Constant;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class PlController {
 @Resource
 PlService plService;
 @Resource
 RedisTemplate<String,SendPage> redisTemplate;
 @RequestMapping("addPl")
 public String addPl(Pl pl,HttpSession session){
  Vip user = (Vip) session.getAttribute("user");
  VipState v=plService.getaaa(user.getId());
  if(user!=null&&user.getStatus()==0){
   return "2";
  }else{
   String s = plService.addPl(pl);
   Set<String> keys = redisTemplate.keys(Constant.fenye + "*");
   redisTemplate.delete(keys);
   return s;
  }
 }
 @RequestMapping("queryPl")
 public SendPage queryPl(ReceivePage rp,Pl pl){
  SendPage sendPage =null;
  if(redisTemplate.hasKey(Constant.fenye+rp.getPage())){
   sendPage = redisTemplate.opsForValue().get(Constant.fenye + rp.getPage());
  }else{
    sendPage = plService.queryPl(rp, pl);
   if(sendPage!=null){
    redisTemplate.opsForValue().set(Constant.fenye+rp.getPage(),sendPage,24, TimeUnit.HOURS);
   }
  }
  return sendPage;
 }
 @RequestMapping("addHuiFu")
 public String addHuiFu(Huifu huifu,HttpSession session){
  Vip user = (Vip) session.getAttribute("user");
  if(user.getStatus()==0){
   return "2";
  }else {
   String s = plService.addHuiFu(huifu);
   return s;
  }
 }
 @RequestMapping("queryHuiFu")
 public List<Huifu> queryHuiFu(Huifu huifu){
   return plService.queryHuiFu(huifu);
 }

}
