package com.jk.controller;

import com.jk.service.TreeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("tree")
public class TreeController {

    @Resource
    private TreeService treeService;

    @ResponseBody
    @RequestMapping("getTree")
    public List<Tree> getTree() {

        List<Tree> tree = treeService.getTree();
        return tree;


    }
}
