package com.jk.service.impl;

import com.jk.bean.Advert;
import com.jk.mapper.AdvertMapper;
import com.jk.service.AdvertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Resource
    private AdvertMapper advertMapper;

    @Override
    public List<Advert> getAdvert(Integer id) {
        return advertMapper.getAdvert(id);
    }
}
