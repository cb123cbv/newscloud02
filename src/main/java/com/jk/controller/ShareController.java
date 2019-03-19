package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpClient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/18
 * @since 1.0.0
 */
@Controller
public class ShareController {

    @ResponseBody
    @RequestMapping("share")
    public String maps(String data) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", "a179a1594f96e65ccf51e9801da3187d");
        params.put("text",data);
        String allresult = HttpClient.sendGet("http://apis.juhe.cn/qrcode/api", params);
        JSONObject jsonObject = JSONObject.parseObject(allresult);
        JSONObject result = jsonObject.getJSONObject("result");
        String base64_image = result.getString("base64_image");
        return base64_image;
    }




}
