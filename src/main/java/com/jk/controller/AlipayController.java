package com.jk.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.bean.*;
import com.jk.config.AlipayConfig;
import com.jk.service.PayService;
import com.jk.service.VipStateService;
import com.jk.utils.OrderCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("zhifu")
public class AlipayController {


    @Resource
    private PayService payService;

    @Resource
    private VipStateService vipStateService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("toView")
    public String toView(String view){

        return view;
    }


    // 获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.url;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.format;
    String public_key = AlipayConfig.public_key;
    String signtype = AlipayConfig.signtype;


    /**
     * 支付请求
     */
    String sss="";//钱
    Integer zzz=0;//月 :1 3 6
    Integer ccc=0;//充余额
    @RequestMapping("newsToPay")
    public void pay(HttpServletRequest request, HttpServletResponse response,Common common) throws Exception {
        zzz=common.getMonth();
        sss=common.getMoney();
        ccc=common.getPaystate();
        // 模拟从前台传来的数据
        String orderNo = OrderCode.getOrderCode(); // 生成订单号
        String totalAmount = sss; // 支付总金额
        String subject = "orderName"; // 订单名称
        String body = "充值"; // 商品描述

        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);

        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderNo); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount(totalAmount); // 支付总金额
        model.setTimeoutExpress("100s");//100s 二维码失效,交易失败
        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        String form = client.pageExecute(alipayRequest).getBody(); // 生成表单

        response.setContentType("text/html;charset=" + charset);
        //getWriter字符流
        response.getWriter().write(form); // 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();


    }

    /**
     * 同步跳转
     */
    @RequestMapping("returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
        //    valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");

            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        // 返回界面
        if (signVerified) {

            Double qian=0.00;
            try {
                qian = Double.parseDouble(sss);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            //-------------------------------------------------------------------------支付宝支付
            Vip users = (Vip) session.getAttribute("user");
            System.out.println(users);
            Integer flag=0;
            if(ccc==0&&zzz==0){//支付宝充值积分
                flag=1;//支付宝充积分
                payService.addjifen(users,qian);//
            }
            if(zzz>0){//支付宝充值vip
                flag=2;//支付宝充值vip
                VipState vipState = new VipState();
                vipState.setYue(zzz);
                vipState.setUserid(users.getId());
                vipStateService.addVipState(vipState);
            }
            if(ccc!=0){//支付宝充值余额
                flag=3;//支付宝充值余额
                payService.addYue(users,qian);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Log log = new Log();
            log.setDatetime(sdf.format(new Date()));
            log.setMoney(sss);
            log.setUserid(users.getId());
            if(flag==1){
                log.setText("支付宝充值积分");
            }
            if(flag==2){
                log.setText("支付宝充值vip,充值"+zzz+"个月");
            }
            if(flag==3){
                log.setText("支付宝充值余额");
            }
            mongoTemplate.insert(log);



            System.out.println("前往支付成功页面");
            mav.setViewName("successReturn");

        } else {
            System.out.println("前往支付失败页面");
            mav.setViewName("failReturn");
        }
        return mav;
    }


    /**
     * 支付宝服务器异步通知
     */
    @RequestMapping("notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
        //    valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库
        } else {
            System.out.println("异步通知失败");
        }
    }

    //查询积分
    @RequestMapping("queryJifen")
    @ResponseBody
    public Jifen queryJifen(HttpSession session){
        Vip users = (Vip) session.getAttribute("user");
        Jifen jifen = payService.queryjifen(users);

        return jifen;
    }

    //余额支付
    @RequestMapping("yuePay")
    @ResponseBody
    public String yuePay(HttpSession session,Jifen jifen,Double qian){
        Vip users = (Vip) session.getAttribute("user");

        payService.yuePay(users,jifen,qian);

        return "1";
    }


    //确认支付密码是否正确
    @RequestMapping("queryByPaypwd")
    @ResponseBody
    public String queryByPaypwd(HttpSession session,String r) {
        Vip users = (Vip) session.getAttribute("user");
        Integer count = payService.getPwdcountByUserId(users.getId());

        if (count < 3) {//比对密码
            Vip vipFromDb = payService.queryByUserIdAndPaypwd(users.getVipaccount(), r);
            if (vipFromDb == null) {
                payService.updateCount(users.getId()); //输错密码 count+1
                return "0";//支付密码错误
            } else {
                if(vipFromDb.getPwdcount()!=0){
                    payService.updateCountToNormal(users.getId());
                }
                return "1";//密码正确
            }
        }
            return "2";//账号异常

    }

}
