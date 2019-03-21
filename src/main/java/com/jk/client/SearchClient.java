package com.jk.client;

import com.jk.bean.Blog_Info;
import com.jk.bean.Common;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("searchInfo")
public interface SearchClient {
    @RequestMapping("getInfoAndTileInfo")
    List<Blog_Info> getInfoAndTileInfo(@RequestParam(value = "queryString")String queryString,@RequestParam(value = "status")Integer status);

    @RequestMapping("addInfo")
    void addInfo(@RequestParam(value = "string")String string);
}
