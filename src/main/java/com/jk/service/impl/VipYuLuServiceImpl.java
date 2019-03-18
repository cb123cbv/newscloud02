package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Vip;
import com.jk.bean.VipYuLu;
import com.jk.mapper.VipYuLuMapper;
import com.jk.service.VipYuLuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class VipYuLuServiceImpl implements VipYuLuService {
 @Resource
 VipYuLuMapper vipYuLuMapper;

 @Override
 public List<VipYuLu> getVipYuLu() {
  return vipYuLuMapper.getVipYuLu();
 }

 @Override
 public List<Vip> meizhourenqi() {
  return vipYuLuMapper.meizhourenqi();
 }
}
