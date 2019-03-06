package com.jk.controller;

import com.jk.bean.Vip;
import com.jk.service.LoginService;
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

  @ResponseBody
  @RequestMapping("login")
  public String getLogin(Vip vip, HttpSession session){
    Vip usersFromdb = loginService.getLogin(vip);
    if(usersFromdb==null){
      return "2";
    }
    session.setAttribute("user",usersFromdb);
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
}
