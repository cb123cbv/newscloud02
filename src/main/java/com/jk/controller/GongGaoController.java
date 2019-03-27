package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import com.jk.service.GongGaoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class GongGaoController {
 @Resource
 GongGaoService gongGaoService;
 @Resource
 RedisTemplate<String,GongGao> redisTemplate;
 @RequestMapping("getGongGao")
 public GongGao getGongGao() {
  GongGao gg=null;
  if (redisTemplate.hasKey("putonggonggao")){
   gg = redisTemplate.opsForValue().get("putonggonggao");
  }else{
   gg=gongGaoService.getGongGao();
   redisTemplate.opsForValue().set("putonggonggao",gg,60, TimeUnit.HOURS);
  }
  return gg;
 }
 @RequestMapping("getGGao")
 public GongGao getGGao(){
  GongGao gg=null;
  if (redisTemplate.hasKey("zhongdagonggao")){
   gg = redisTemplate.opsForValue().get("zhongdagonggao");
  }else{
   gg=gongGaoService.getGGao();
   redisTemplate.opsForValue().set("zhongdagonggao",gg,60, TimeUnit.HOURS);
  }
  return gg;
 }

}
