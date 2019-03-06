package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Title;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class TreeServiceImpl implements TreeService {
 @Resource
 TreeMapper treeMapper;
 @Override
 public List<Title> getTree() {
  List<Title> tree = treeMapper.getTree();
  return tree;
 }
}
