package com.jk.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/17
 * @since 1.0.0
 */
@FeignClient("rediscluster")
public interface RedisClusterClient {
    @RequestMapping("setRedisCluster")
    void setRedisCluster(@RequestParam(value = "queryString") String queryString);

    @RequestMapping("getInfoByRedis")
    List<String> getInfoByRedis();

    @RequestMapping("deleteInfoByRedis")
    void deleteInfoByRedis();
}
