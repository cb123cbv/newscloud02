package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.VipYuLu;
import com.jk.utils.Constant;
import com.jk.utils.HttpClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("http")
public class HttpController {
    @Resource
    RedisTemplate<String,List> redisTemplate;
    //新闻
    @ResponseBody
    @RequestMapping(value="news",produces = "application/json; charset=utf-8")
    public List<Object> news(String flag){
        List<Object> list = new ArrayList<Object>();
        Map<String, Object> params = new HashMap<>();
        if(redisTemplate.hasKey(Constant.xinwen)){
            list = redisTemplate.opsForValue().get(Constant.xinwen);
        }else{
            params.put("type",flag);
            params.put("key", "be6460ae8aa48d63ec1a33b6eaf86f52");
            String result = HttpClient.sendGet("http://v.juhe.cn/toutiao/index",params);
            //result是一个json字符串  ,要把他转换成对象可以更好地取值
            JSONObject parseObject = JSONObject.parseObject(result);
            String string = parseObject.getString("reason");
            JSONObject resultJson = parseObject.getJSONObject("result");
            String string2 = resultJson.getString("stat");
            JSONArray data = resultJson.getJSONArray("data");
            for (Object object : data) {
                list.add(object);
            }
            redisTemplate.opsForValue().set(Constant.xinwen,list,60, TimeUnit.HOURS);
        }
        return list;
    }
}
