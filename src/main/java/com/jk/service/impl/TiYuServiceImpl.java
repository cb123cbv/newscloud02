package com.jk.service.impl;

import com.jk.bean.Info;
import com.jk.bean.LanMuBiaoTi;
import com.jk.bean.TiYu;
import com.jk.mapper.TiYuMapper;
import com.jk.service.TiYuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TiYuServiceImpl implements TiYuService {

    @Resource
    private TiYuMapper tiYuMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<LanMuBiaoTi> getOne(String tablename) {
        return tiYuMapper.getOne(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getTwo(String tablename) {
        return tiYuMapper.getTwo(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getThree(String tablename) {
        return tiYuMapper.getThree(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getFour(String tablename) {
        return tiYuMapper.getFour(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getFive(String tablename) {
        return tiYuMapper.getFive(tablename);
    }

    @Override
    public List<LanMuBiaoTi> getSix(String tablename) {
        return tiYuMapper.getSix(tablename);
    }

    @Override
    public List<TiYu> getTiYu(String tablename) {
        List<TiYu> list2 = new ArrayList<>();
        List<TiYu> list = tiYuMapper.getTiYu(tablename);
        for (int i = 0; i<=2;i++ ) {
            TiYu tiYu = list.get(i);
            Query query = new Query();
            String id = String.valueOf(tiYu.getId());
            query.addCriteria(Criteria.where("titleId").is(id));
            query.addCriteria(Criteria.where("tableName").is(tablename));
            Info info = mongoTemplate.findOne(query, Info.class);
            if(info!=null){
                tiYu.setInfo(info.getInfo());
            }
            list2.add(tiYu);
        }
        return list2;
    }
}
