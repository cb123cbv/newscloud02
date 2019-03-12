package com.jk.service.impl;

import com.jk.bean.Common;
import com.jk.bean.Info;
import com.jk.mapper.WirteMapper;
import com.jk.service.WirteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WirteServiceImpl implements WirteService {

    @Resource
    private WirteMapper wirteMapper;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Common> queryBiaoQian() {
        return wirteMapper.queryBiaoQian();
    }

    @Override
    public void addWrite(Common common) {
        common.setSelectName("t_"+common.getSelectName());
        wirteMapper.addwrite(common);
        Info info = new Info();
        info.setInfo(common.getTextName());
        info.setTableName(common.getSelectName());
        info.setTitleId(common.getTitleid());
        mongoTemplate.insert(info);
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
