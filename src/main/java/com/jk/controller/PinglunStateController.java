package com.jk.controller;

import com.jk.bean.PingLun_State;
import com.jk.bean.Vip;
import com.jk.service.PinglunStateService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("pinglun")
public class PinglunStateController {

    @Resource
    private PinglunStateService pinglunStateService;

    @Resource
    private RedisTemplate<String, List<PingLun_State>> redisTemplate;

    @ResponseBody
    @RequestMapping("pingLunCount")
    public Integer pingLunCount(HttpSession session) {
        Integer count = 0;
        Vip vip = (Vip) session.getAttribute("user");
        if (vip != null) {
            count = pinglunStateService.pingLunCount(vip.getId());
        }
        return count;
    }


    @ResponseBody
    @RequestMapping("querypingLunList")
    public List<PingLun_State> querypingLunList(HttpSession session) {
        List<PingLun_State> list=null;
        Vip vip = (Vip) session.getAttribute("user");
        if (vip != null) {
            list = pinglunStateService.querypingLunList(vip.getId());
            for (PingLun_State pingLun_state : list) {
                if (pingLun_state.getTitle().length()>19) {
                    String substring = pingLun_state.getTitle().substring(0, 17);
                    pingLun_state.setTitle(substring+"....");
                }
                if (pingLun_state.getInfo().length()>19) {
                    String substring = pingLun_state.getInfo().substring(0, 17);
                    pingLun_state.setInfo(substring+"...");
                }
            }
        }
        return list;
    }


}




