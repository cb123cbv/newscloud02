package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Common;
import com.jk.bean.VipYuLu;
import com.jk.service.MeiRiJingXuanService;
import com.jk.utils.Constant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class MeiRiJingXuanController {
 @Resource
 MeiRiJingXuanService meiRiJingXuanService;
 @Resource
 RedisTemplate<String,List<Common>> redisTemplate;
 @RequestMapping("getYuLe2")
 public List<Common> getYuLe2(){
  List<Common> list=null;
  if(redisTemplate.hasKey(Constant.yule2)){
   list = redisTemplate.opsForValue().get(Constant.yule2);
  }else{
   list=meiRiJingXuanService.getYuLe2();
   redisTemplate.opsForValue().set(Constant.yule2,list,60, TimeUnit.HOURS);
  }
  return list;
 }
 @RequestMapping("gettiyu2")
 public List<Common> gettiyu2(){
  List<Common> list=null;
  if(redisTemplate.hasKey(Constant.tiyu2)){
   list = redisTemplate.opsForValue().get(Constant.tiyu2);
  }else{
   list=meiRiJingXuanService.gettiyu2();
   redisTemplate.opsForValue().set(Constant.tiyu2,list,60, TimeUnit.HOURS);
  }
  return list;
 }
 @RequestMapping("getcaijing2")
 public List<Common> getcaijing2(){
  List<Common> list=null;
  if(redisTemplate.hasKey(Constant.caijing2)){
   list = redisTemplate.opsForValue().get(Constant.caijing2);
  }else{
   list=meiRiJingXuanService.getcaijing2();
   redisTemplate.opsForValue().set(Constant.caijing2,list,60, TimeUnit.HOURS);
  }
  return list;
 }
 @RequestMapping("getjunshi2")
 public List<Common> getjunshi2(){
  List<Common> list=null;
  if(redisTemplate.hasKey(Constant.junshi2)){
   list = redisTemplate.opsForValue().get(Constant.junshi2);
  }else{
   list=meiRiJingXuanService.getjunshi2();
   redisTemplate.opsForValue().set(Constant.junshi2,list,60, TimeUnit.HOURS);
  }
  return list;
 }
}
