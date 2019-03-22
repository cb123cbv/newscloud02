package com.jk.controller;

import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import com.jk.service.TiYuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tiyu")
public class TiYuController {

    @Autowired
    private TiYuService tiYuService;

    @ResponseBody
    @RequestMapping("getTiYu")
    public List<TiYu> getTiYu(String tablename){

        return tiYuService.getTiYu(tablename);
    }

    @ResponseBody
    @RequestMapping("getOne")
    public List<LanMuBiaoTi> getOne(String tablename){

        return tiYuService.getOne(tablename);
    }
    @ResponseBody
    @RequestMapping("getTwo")
    public List<LanMuBiaoTi> getTwo(String tablename){

        return tiYuService.getTwo(tablename);
    }
    @ResponseBody
    @RequestMapping("getThree")
    public List<LanMuBiaoTi> getThree(String tablename){

        return tiYuService.getThree(tablename);
    }
    @ResponseBody
    @RequestMapping("getFour")
    public List<LanMuBiaoTi> getFour(String tablename){

        return tiYuService.getFour(tablename);
    }
    @ResponseBody
    @RequestMapping("getFive")
    public List<LanMuBiaoTi> getFive(String tablename){

        return tiYuService.getFive(tablename);
    }
    @ResponseBody
    @RequestMapping("getSix")
    public List<LanMuBiaoTi> getSix(String tablename){

        return tiYuService.getSix(tablename);
    }
}
