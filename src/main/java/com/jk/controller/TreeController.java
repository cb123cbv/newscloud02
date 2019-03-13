package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Title;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：
 * &lt;/pre&gt;
 */
@Controller
public class TreeController {
 @Autowired
 TreeService treeService;
 @ResponseBody
 @RequestMapping("getTree")
 public List<Title> getTree(){
  List<Title> tree=treeService.getTree();
  return tree;
 }
}
