package com.jk.controller;


import com.jk.bean.Common;
import com.jk.client.SearchClient;
import com.jk.service.WirteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("wirte")
public class WirteController {

    @Resource
    private WirteService wirteService;
    @Autowired
    SearchClient searchClient;

    //public long timeDate=0;
    Common common3=new Common();
   List<Common> commons=new ArrayList<Common>();


    @Scheduled(fixedRate = 3000)
    public void autosync() {

        if (commons.size()>0) {
            for (int i = 0; i < commons.size(); i++) {
                if ( commons.get(i).getEndTime()!= null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date parse =null;

                    try {
                        parse = sdf.parse(commons.get(i).getEndTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long seconds = parse.getTime()-new Date().getTime();
                    System.out.println(seconds+"总剩余时间"+i);
                    if(seconds<0){
                        //获取对象，走新增方法
                        System.out.println("去新增了");
                        commons.get(i).setTimeDate(2);
                        common3=commons.get(i);
                        commons.remove(i);
                        addWrite(common3);
                    }
                }
            }
        }
    }

    @ResponseBody
    @RequestMapping("addWrite")
    public void addWrite(Common common) {
        if (common.getEndTime()=="") {
            if(StringUtils.isEmpty(common.getJifen())){
                common.setJifen(0);
            }
            wirteService.addWrite(common);
        }
        if(!StringUtils.isEmpty(common.getEndTime())){
            if(common.getTimeDate()==1){
                commons.add(common);
            }
            if (common.getTimeDate()==2) {
                if(StringUtils.isEmpty(common.getJifen())){
                    common.setJifen(0);
                }
                wirteService.addWrite(common);
                System.out.println("新增成功");
            }
        }

    }



    @ResponseBody
    @RequestMapping("queryBiaoQian")
    public List<Common> queryBiaoQian() {
        List<Common> commons = wirteService.queryBiaoQian();

        return commons;
    }
 //  @RabbitListener(queues = "1807B-SendEs")
  

    @RequestMapping("tomap")
    public String tomap(HttpSession session,Common common){
        session.setAttribute("common",common);

        return "map";
    }


    @RequestMapping("toWirte")
    public String toWirte(String site,HttpSession session){
        Common common = (Common) session.getAttribute("Common");
        common.setSite(site);
        session.setAttribute("common",common);
        return "WriteWeibo";
    }




}





