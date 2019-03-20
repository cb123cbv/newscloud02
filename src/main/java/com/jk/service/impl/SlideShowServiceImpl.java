package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.SlideShow;
import com.jk.mapper.SlideMappper;
import com.jk.service.SlideShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class SlideShowServiceImpl implements SlideShowService {
 @Resource
 SlideMappper slidMappper;

 @Override
 public SlideShow getRenqiStatus(SlideShow slideShow) {

  return slidMappper.getRenqiStatus(slideShow);
 }

}
