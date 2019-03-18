package com.jk.conf;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Configuration
public class RabbitMQConfiguration {
 @Bean
 public Queue queueMessage(){
  // 参数为自定义队列名称
  return new Queue("1807B-SendEs");
 }
}
