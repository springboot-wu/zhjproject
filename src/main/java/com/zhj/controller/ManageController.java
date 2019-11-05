package com.zhj.controller;

import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.service.ManageService;
import com.zhj.util.ExportExcel;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:49
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    //申报记录查询
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
        return  manageService.Query(param);
    }
    //申报记录新增,修改
    @RequestMapping("Add")
    @ResponseBody
    public String Add(Declare d){
        if(d.getId()==null ){

            try {
                manageService.Add(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }
        }else{
            try {
                manageService.Update(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }

        }
    }
    //申报记录删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            manageService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //申报记录删除
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(String [] id){

        try {
            manageService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }

    }

    //导出excel方法 （数据库查询数据 使用封装工具类导出）
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response, HttpServletRequest request){
        //导出的excel的标题
        String title = "申报记录";  //自定义
        //导出excel的自定义列名
        String[] rowName = {"序号","账号","姓名","电量申报日期","用电日期","申报电量(万千瓦时)","当月正常生产天数","跟上月同比","跟去年相同月同比","企业补充说明","状态"};
        //导出的excel数据  定义list集合
        List<Object[]>  dataList = new ArrayList<Object[]>();

        //查询的数据库的信息
        Users u = (Users) request.getSession().getAttribute("users");
        List<Declare> list= manageService.query(u.getId()); //查询

        //循环数据库查到的信息
        for(Declare c:list){
            Object[] obj =new Object[rowName.length];  //new 对象数组
            obj[0]=c.getDeclaretime();
            obj[1]=c.getName();
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //时间类型转化
            String format = sdf.format(c.getDeclaretime());
            obj[2]=format;
            String mat = sdf.format(c.getElectrotime());
            obj[3]=mat;
            obj[4]=c.getElectro();
            obj[5]=c.getDays();
            obj[6]=c.getLastmonth();
            obj[7]=c.getSamemoth();
            obj[8]=c.getExplain();
            if(c.getStatus()==1){
                obj[9]="已申报";
            }else if(c.getStatus()==2){
                obj[9]="未申报";
            }else{
                obj[9]="未开始";
            }

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


}
