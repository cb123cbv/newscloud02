package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.SlideShow;
import com.jk.service.SlideShowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class SlideShowController {

 @Resource
 SlideShowService slideShowService;

 @RequestMapping("getRenqiStatus")
 public SlideShow getRenqiStatus(SlideShow slideShow){

  SlideShow ss=  slideShowService.getRenqiStatus(slideShow);
  return  ss;
 }

}

