package com.jk.client;

import com.jk.bean.Common;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
@FeignClient("newscloud-rabbitmq")
public interface SendESClient {
 @RequestMapping("sendES")
 void sendES(Common common);
}
