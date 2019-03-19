package com.jk.controller;

import com.jk.bean.Blog_Info;
import com.jk.client.RedisClusterClient;
import com.jk.client.SearchClient;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/11
 * @since 1.0.0
 */
@RestController
public class SearchController {

    @Resource
    SearchClient searchClient;
    @Resource
    RedisClusterClient redisClusterClient;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("getInfoAndTileInfo")
    public List<Blog_Info>  getInfoAndTileInfo(String queryString, Integer status){
        redisClusterClient.setRedisCluster(queryString);
        List<Blog_Info> list = searchClient.getInfoAndTileInfo(queryString,status);

        return list;
    }

    @RequestMapping("getInfo")
    public  List<String> getInfo(){
        List<String> range =redisClusterClient.getInfoByRedis();
        return range;
    }

    @RequestMapping("deleteInfo")
    public void deleteInfo(){
        redisClusterClient.deleteInfoByRedis();

    }
}
