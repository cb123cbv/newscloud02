package com.jk.controller;


import com.jk.bean.Vip;
import com.jk.service.VipService;
import com.jk.utils.PinyinUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("vip")
public class VipController {

    @Resource
    private VipService vipService;


    //查询所有用户
    @RequestMapping("getAllBoZhu")
    @ResponseBody
    public List<Vip> getAllBoZhu(){

        PinyinUtil pinyin = new PinyinUtil();//转英文的工具类
        ArrayList<String> pinyinList = new ArrayList<>();//转成英文存放的数组
        List<Vip> list2 = new ArrayList<>();//存放最终返回前台的数据

        List<Vip> list =vipService.getAllBoZhu();//查询所有用户
        for (Vip vip : list) {

            String strPinyin = pinyin.getStringPinYin(vip.getVipname());
            vip.setPinyiname(strPinyin);
            pinyinList.add(strPinyin);//存放英文名字
        }

        Collections.sort(pinyinList, (a, z) -> a.compareTo(z));//实现字母排序

        for (String s : pinyinList) {
            for (Vip vip : list) {
                if(s.equals(vip.getPinyiname())&&vip.getZt()==0){
                    list2.add(vip);
                    vip.setZt(1);
                }
            }

        }

        return list2;
    }



}
