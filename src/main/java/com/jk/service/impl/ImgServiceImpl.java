package com.jk.service.impl;

import com.jk.bean.ImgInfo;
import com.jk.mapper.ImgMapper;
import com.jk.service.ImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Resource
    ImgMapper imgMapper;
    @Override
    public List<ImgInfo> queryImg() {
        return imgMapper.queryImg();
    }
}
