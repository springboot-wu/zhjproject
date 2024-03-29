package com.zhj.controller;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.service.ClientService;
import com.zhj.util.ExportExcel;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:29
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //客户列表查询
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
       return clientService.Query(param);
    }
    //客户列表新增、修改
    @RequestMapping("Add")
    @ResponseBody
    public String Query(Client c){
        if(c.getId()==null){

            try {
                clientService.Add(c);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }
        }else{
            try {
                clientService.Update(c);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }

        }
    }
  //客户管理删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            clientService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //客户管理批删
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(String[] id) {
        try {
            clientService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }

    }
    //公众号结算查询
    @RequestMapping("QueryUsers")
    @ResponseBody
    public List<Deal> QueryUsers(@RequestBody ParamUtil param){
        return  clientService.QueryUsers(param.getTime());
    }
    //公众号修改密码
    @RequestMapping("Password")
    @ResponseBody
    public  String Password(@RequestBody ParamUtil param,HttpServletRequest request){
            Users users = (Users) request.getSession().getAttribute("users");

            Users  u=clientService.Password(param.getOldpassword(),users.getId());
             if (u==null){
               return "1";
             }else {
                 clientService.OldPassword(param.getPassword(),u.getId());
                 return "2";
             }



    }
    //导出excel方法 （数据库查询数据 使用封装工具类导出）
    @RequestMapping("exportExcel")
    public void exportExcel(@RequestBody ParamUtil param,HttpServletResponse response){

        //导出的excel的标题
        String title = "电力结算优惠单";  //自定义
        //导出excel的自定义列名
        String[] rowName = {"序号","交易电量","实际用电量","偏差电量","允许偏差电量(-2%、+6%)","考核执行偏差","偏差考核费用","用户偏差考核费用","代理售电公司考核费用","优惠金额","合计优惠金额","备注"};
        //导出的excel数据  定义list集合
        List<Object[]>  dataList = new ArrayList<Object[]>();

        //查询的数据库的信息
        List<Deal> list= clientService.QueryUsers(param.getDate()); //查询

        //循环数据库查到的信息
        for(Deal c:list){
            Object[] obj =new Object[rowName.length];  //new 对象数组
            obj[1]=c.getElectric();
            obj[2]=c.getPractical();
           // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //时间类型转化
           //String format = sdf.format(c.getDeclaretime());
            obj[3]=c.getPower();
            obj[4]=c.getDeviationratio();
            obj[5]=c.getBias();
            obj[6]=c.getAssess();
            obj[7]=c.getDeviation();
            obj[8]=c.getUserfees();
            obj[9]=c.getCompanyexpense();
            obj[10]=c.getDiscount();
            obj[11]=c.getTotaldiscount();
            obj[12]=c.getRemake();
            dataList.add(obj);  //将数组对象 放入定义的list里
        }

        //调用工具类ExportExcel  传入4个固定参数title,rowName,dataList,response  导出
        ExportExcel exportExcel =new ExportExcel(title,rowName,dataList,response);
        try {
            exportExcel.export();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
  //公众号电力申报新增
    @RequestMapping("AddDeclare")
    @ResponseBody
    public String AddDeclare(Declare declare){
        try {
            clientService.AddDeclare(declare);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //公众号用户信息
    @RequestMapping("Message")
    @ResponseBody
    public List<Users> Message(HttpSession session){

        System.err.println(session.getId()+"888888888888");
        Users users = (Users) session.getAttribute("users");
        return clientService.Message(users.getId());

    }
  //密码查询
    @RequestMapping("QueryPassword")
    @ResponseBody
    public List<Users> QueryPassword(HttpSession session) {
        Users us = (Users) session.getAttribute("users");
        return clientService.QueryPassword(us.getId());
    }
    //历史更多
    @RequestMapping("More")
    @ResponseBody
    public  List<Deal> More(@RequestBody ParamUtil param){
       return clientService.More(param);
    }
    //公众号申报时间
    @RequestMapping("DateTime")
    @ResponseBody
    public Map DateTime(){
        return clientService.DateTime();
    }
}
