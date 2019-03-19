package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Common;
import com.jk.service.MeiRiJingXuanService;
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
public class MeiRiJingXuanController {
 @Resource
 MeiRiJingXuanService meiRiJingXuanService;
 @RequestMapping("getYuLe2")
 public List<Common> getYuLe2(){
  return meiRiJingXuanService.getYuLe2();
 }
 @RequestMapping("gettiyu2")
 public List<Common> gettiyu2(){
  return meiRiJingXuanService.gettiyu2();
 }
 @RequestMapping("getcaijing2")
 public List<Common> getcaijing2(){
  return meiRiJingXuanService.getcaijing2();
 }
 @RequestMapping("getjunshi2")
 public List<Common> getjunshi2(){
  return meiRiJingXuanService.getjunshi2();
 }
}
