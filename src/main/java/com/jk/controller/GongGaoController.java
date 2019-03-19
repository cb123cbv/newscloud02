package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.GongGao;
import com.jk.service.GongGaoService;
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
public class GongGaoController {
 @Resource
 GongGaoService gongGaoService;
 @RequestMapping("getGongGao")
 public GongGao getGongGao(){
  return gongGaoService.getGongGao();
 }
 @RequestMapping("getGGao")
 public GongGao getGGao(HttpSession session){
  GongGao gg= gongGaoService.getGGao();
  return gg;
 }

}
