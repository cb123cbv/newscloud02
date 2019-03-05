package com.jk.service.impl;

import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Resource
    TreeMapper treeMapper;

    @Override
    public List<Tree> getTree() {
        List<Tree> tree = treeMapper.getTreeList();

        return tree;
    }


}
