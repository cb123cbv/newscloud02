package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Common;
import com.jk.mapper.MeiRiJingXuanMapper;
import com.jk.service.MeiRiJingXuanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class MeiRiJingXuanServiceImpl implements MeiRiJingXuanService {
 @Resource
 MeiRiJingXuanMapper meiRiJingXuanMapper;

 @Override
 public List<Common> getYuLe2() {
  return meiRiJingXuanMapper.getYuLe2();
 }

 @Override
 public List<Common> gettiyu2() {
  return meiRiJingXuanMapper.gettiyu2();
 }

 @Override
 public List<Common> getcaijing2() {
  return meiRiJingXuanMapper.getcaijing2();
 }

 @Override
 public List<Common> getjunshi2() {
  return meiRiJingXuanMapper.getjunshi2();
 }
}
