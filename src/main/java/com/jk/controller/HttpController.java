package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("http")
public class HttpController {
    //新闻
    @ResponseBody
    @RequestMapping(value="news",produces = "application/json; charset=utf-8")
    public List<Object> news(String flag){

        Map<String, Object> params = new HashMap<>();


        params.put("type",flag);
        params.put("key", "c6894764e93d72e3747c1ab039c9050e");
        String result = HttpClient.sendGet("http://v.juhe.cn/toutiao/index",params);

        //result是一个json字符串  ,要把他转换成对象可以更好地取值
        JSONObject parseObject = JSONObject.parseObject(result);
        String string = parseObject.getString("reason");
        JSONObject resultJson = parseObject.getJSONObject("result");
        String string2 = resultJson.getString("stat");
        JSONArray data = resultJson.getJSONArray("data");
        List<Object> list = new ArrayList<Object>();
        for (Object object : data) {
            list.add(object);
        }

        return list;
    }
}
