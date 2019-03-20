package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.bean.Log;
import com.jk.client.MongodbClient;
import com.jk.service.MongodbLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class MongodbLogServiceImpl implements MongodbLogService {
 @Resource
 MongodbClient mongodbClient;
 @Override
 public void addmongodbLog(Log log) {
  mongodbClient.addLog(log);
 }
}
