package com.jk.controller;

import com.jk.bean.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/3/7
 * @since 1.0.0
 */
@RestController
public class InfoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("getInfoById")
    public List<Info> getInfoById(String titleId,String tableName){
        Query query = new Query();
        query.addCriteria(Criteria.where("titleId").is(titleId));
        query.addCriteria(Criteria.where("tableName").is(tableName));
       List<Info> list= mongoTemplate.find(query, Info.class);

        return list;
    }

}
