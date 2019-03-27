package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Blog_Info;
import com.jk.bean.Common;
import com.jk.bean.Info;
import com.jk.client.SearchClient;
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

    @Resource
    SearchClient searchClient;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Common> queryBiaoQian() {
        return wirteMapper.queryBiaoQian();
    }

    @Override
    public void addWrite(Common common) {
        Blog_Info info1=new Blog_Info();
        info1.setTitleinfo(common.getTitle());
        info1.setTablename("t_"+common.getSelectName());
        info1.setInfo(common.getTextName());
        String string = JSONObject.toJSONString(info1);
        searchClient.addInfo(string);





        common.setSelectName("t_"+common.getSelectName());
        wirteMapper.addwrite(common);
        Info info=new Info();
        info.setTitleId(String.valueOf(common.getTitleid()));
        info.setInfo(common.getTextName());
        info.setTableName(common.getSelectName());
        mongoTemplate.insert(info);
        //mongodbClient.addInfo(String.valueOf(common.getTitleid()),common.getSelectName(),common.getTextName());
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
