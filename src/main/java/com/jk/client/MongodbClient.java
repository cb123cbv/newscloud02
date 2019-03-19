package com.jk.client;

import com.jk.bean.Info;
import com.jk.bean.Log;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
@FeignClient("newscloud-mongodb")
public interface MongodbClient {
 @RequestMapping("getInfoById")
 Info getInfoById(@RequestParam(value = "titleId")String titleId,@RequestParam(value = "tableName")String tableName);
 @RequestMapping("addInfo")
 void addInfo(@RequestParam(value = "titleId")String titleId,@RequestParam(value = "tableName")String tableName,@RequestParam(value = "info")String info);
 @RequestMapping("addLog")
 void addLog(@RequestParam(value = "log") Log log);
}
