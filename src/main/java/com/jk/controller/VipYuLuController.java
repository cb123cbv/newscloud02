package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Vip;
import com.jk.bean.VipYuLu;
import com.jk.service.VipYuLuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class VipYuLuController {
   @Resource
 VipYuLuService vipYuLuService;
   @RequestMapping("getVipYuLu")
 public List<VipYuLu> getVipYuLu(){
    return vipYuLuService.getVipYuLu();
   }
   @RequestMapping("meizhourenqi")
 public List<Vip> meizhourenqi(){
    return vipYuLuService.meizhourenqi();
   }
}
