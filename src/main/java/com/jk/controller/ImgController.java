package com.jk.controller;


import com.jk.bean.ImgInfo;
import com.jk.service.ImgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("img")
public class ImgController {

    @Resource
    private ImgService imgService;

    @RequestMapping("queryImg")
    @ResponseBody
    public List<ImgInfo> queryImg(){
        List<ImgInfo> list = imgService.queryImg();
      return list;
    }
    @RequestMapping("queryImg2")
    @ResponseBody
    public List<ImgInfo> queryImg2(){
        List<ImgInfo> list = imgService.queryImg2();
        return list;
    }

    @RequestMapping("toshowInfo")
    public String toTitleInfo1(Integer titleid, String tablename, Model model){
        model.addAttribute("titleid",titleid);
        model.addAttribute("tablename",tablename);
        return "showInfo2";
    }


}
