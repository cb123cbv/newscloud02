package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Blog_Info;
import com.jk.bean.Common;
import com.jk.bean.Info;
import com.jk.client.MongodbClient;
import com.jk.client.SendESClient;
import com.jk.mapper.WirteMapper;
import com.jk.service.WirteService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WirteServiceImpl implements WirteService {

    @Resource
    private WirteMapper wirteMapper;

    @Autowired
    private MongodbClient mongodbClient;
    @Autowired
    SendESClient sendESClient;

    @Override
    public List<Common> queryBiaoQian() {
        return wirteMapper.queryBiaoQian();
    }

    @Override
    public void addWrite(Common common) {
       /* Blog_Info info=new Blog_Info();
        info.setTitleinfo(common.getTitle());
        info.setTablename("t_"+common.getSelectName());
        info.setInfo(common.getTextName());
        String string = JSONObject.toJSONString(info);
        amqpTemplate.convertAndSend("1807B-SendEs", string);*/
        sendESClient.sendES(common);
        common.setSelectName("t_"+common.getSelectName());
        wirteMapper.addwrite(common);
        mongodbClient.addInfo(String.valueOf(common.getTitleid()),common.getSelectName(),common.getTextName());
        String[] split = common.getBiaoqian().substring(1).split(",");
        for (String s : split) {
            Common common1 = wirteMapper.queryBiaoQianByname(s);
          if(common1==null){
              common.setName(s);
              wirteMapper.addqianbianByName(common);
              wirteMapper.addqianbianWirte(common.getId(),common.getTitleid(),common.getSelectName());
          }
        if(common1!=null){
            wirteMapper.addqianbianWirte(common1.getId(),common.getTitleid(),common.getSelectName());
        }



        }


    }







}
