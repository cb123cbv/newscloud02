package com.jk.controller;

import com.jk.bean.Advert;
import com.jk.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;


    @ResponseBody
    @RequestMapping("getAdvert")
    public List<Advert> getAdvert(Integer id){
        return  advertService.getAdvert(id);
    }
}
