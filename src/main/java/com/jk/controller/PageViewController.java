package com.jk.controller;

import com.jk.bean.Common;
import com.jk.bean.Jifen;
import com.jk.service.PageService;
import com.jk.utils.Constant;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("page")
public class PageViewController {
   @Resource
   private PageService PageService;
   @Resource
 RedisTemplate<String,List<Common>> redisTemplate;
    @ResponseBody
    @RequestMapping("getDjl")
    public SendPage getDjl(ReceivePage ReceivePage,String tablename){
        SendPage  list=  PageService.getDjl(ReceivePage,tablename);
        return list;
    }
    //根据点击量对title进行排行
    @ResponseBody
    @RequestMapping("queryTtph")
    public List<Common> queryTtph(){
     List<Common> list=null;
     if(redisTemplate.hasKey(Constant.biaotipaih)){
      list = redisTemplate.opsForValue().get(Constant.biaotipaih);
     }else{
      list=PageService.queryTtph();
      redisTemplate.opsForValue().set(Constant.biaotipaih,list,60, TimeUnit.HOURS);
     }
        return  list;
    }
    @ResponseBody
    @RequestMapping("queryJifen")
    public Jifen queryJifen(int id){
        Jifen jifen =  PageService.queryJifen(id);
        return  jifen;
    }
}
