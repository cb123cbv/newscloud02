package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Vip;
import com.jk.bean.VipYuLu;
import com.jk.service.VipYuLuService;
import com.jk.utils.Constant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class VipYuLuController {
   @Resource
 VipYuLuService vipYuLuService;
   @Resource
 RedisTemplate<String,List> redisTemplate;
   @RequestMapping("getVipYuLu")
 public List<VipYuLu> getVipYuLu(){
    List<VipYuLu> list=null;
    if(redisTemplate.hasKey(Constant.jianyi)){
     list = redisTemplate.opsForValue().get(Constant.jianyi);
    }else{
     list=vipYuLuService.getVipYuLu();
     redisTemplate.opsForValue().set(Constant.jianyi,list,60, TimeUnit.HOURS);
    }
    return list;
   }
   @RequestMapping("meizhourenqi")
 public List<Vip> meizhourenqi(){
    List<Vip> list=null;
    if(redisTemplate.hasKey(Constant.meizhourenqi)){
     list = redisTemplate.opsForValue().get(Constant.meizhourenqi);
    }else{
     list=vipYuLuService.meizhourenqi();
     redisTemplate.opsForValue().set(Constant.meizhourenqi,list,60, TimeUnit.HOURS);
    }
    return list;
   }
}
