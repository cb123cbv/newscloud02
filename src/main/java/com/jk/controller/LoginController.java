package com.jk.controller;

import com.jk.bean.Jifen;
import com.jk.bean.Vip;
import com.jk.service.LoginService;
import com.jk.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("login")
public class LoginController {
  @Resource
  private LoginService loginService;

  @Resource
  private PageService PageService;

  @ResponseBody
  @RequestMapping("login")
  public String getLogin(Vip vip,HttpSession session){
    Vip usersFromdb = loginService.getLogin(vip);
    if(usersFromdb==null){
      return "2";
    }
    session.setAttribute("user",usersFromdb);
    Jifen jifen =  PageService.queryJifen(usersFromdb.getId());
    //session.setAttribute("jifen",jifen);
    return "1";
  }
  @RequestMapping("toLogin")
  public String toLogin2(){

    return "wopop";
  }
  @ResponseBody
  @RequestMapping("clearSession")
  public String clearSession(HttpSession session){
    session.invalidate();
    return "1";
  }
  @ResponseBody
  @RequestMapping("getUserByQQ")
  public Vip getUserByQQ(Vip vip){

    Vip user= loginService.getUserByQQ(vip);
    return user;
  }

  @ResponseBody
  @RequestMapping("toLoginByQQ")
  public String toLoginByQQ(Vip vip, HttpSession session){
    Vip usersFromdb =  loginService.toLoginByQQ(vip);
    if(usersFromdb==null){
      return "2";
    }
    session.setAttribute("user",usersFromdb);
    return "1";
  }

}
