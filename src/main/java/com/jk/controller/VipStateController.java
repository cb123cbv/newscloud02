package com.jk.controller;



import com.jk.bean.Vip;
import com.jk.bean.VipState;
import com.jk.service.VipStateService;
import com.jk.utils.HttpClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("member")
public class VipStateController {

    @Resource
    private VipStateService vipStateService;

    //查询VIP剩余5天以内的
    @Scheduled(fixedRate = 10000)
    public void autosync() {
        queryVipStart();
    }

    //查询不是VIP的用户
    @Scheduled(fixedRate = 600000)
    public void autosync2() {
        upVipStart2();
    }



    public void queryVipStart() {
        List<VipState> vipList= vipStateService.queryVipStart();
        if (vipList.size()>0) {
            for (VipState vipState : vipList) {
                Vip vip = vipStateService.queryVipById(vipState.getUserid());
                if(!StringUtils.isEmpty(vip.getPhone())){
                    Map<String, Object> params = new HashMap<>();
                    params.put("mobile", vip.getPhone());// 手机号 前台传过来的
                    params.put("tpl_id", "143988");// 模板id
                    params.put("key","99f52898ecf0854b4f9423446967770a");

                    String result = HttpClient.sendGet("http://v.juhe.cn/sms/send",params);//返回的验证码
                    System.out.println("发送成功");
                }
                vipStateService.upVipState(vip.getId());
            }

        }
    }


    public void upVipStart2() {
        vipStateService.queryVipByTime();
    }



    @ResponseBody
    @RequestMapping("addVipState")
    public void addVipState(VipState vipState, HttpSession session){
        Vip user = (Vip) session.getAttribute("user");
        vipState.setUserid(user.getId());
        vipStateService.addVipState(vipState);
        vipStateService.jianMoney(vipState);
    }







   /* @Test
    public void test01(){
        Date date = new Date();
        long time = date.getTime();
        long ss2=4*60*1000;
        long ss= 5*24*60*60*1000;

        System.out.println(time+ss);

    }*/



}
