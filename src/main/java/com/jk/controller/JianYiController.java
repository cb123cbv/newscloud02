package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.JIanYi;
import com.jk.bean.Vip;
import com.jk.service.JianYiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class JianYiController {
 @Resource
 JianYiService jianYiService;
 @RequestMapping("addJIanYi")
 public String addJIanYi(JIanYi j, HttpSession session){
  Vip user = (Vip) session.getAttribute("user");
  if(user==null){
   return "2";
  }
  j.setUserid(user.getId());
  jianYiService.addJIanYi(j);
  return "1";
 }
}
