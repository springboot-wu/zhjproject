package com.zhj.controller;

import com.zhj.model.Deal;
import com.zhj.service.DealService;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:01
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Controller
@RequestMapping("Deal")
public class DealController {
    @Autowired
    private DealService dealService;
    //电力交易结算新增，删除
    @RequestMapping("Add")
    @ResponseBody
    public String Add(Deal d){
        if (d.getId()==null){

            try {
                dealService.Add(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }

        }else{
            try {
                dealService.Update(d);
                return "1";
            } catch(Exception e){
                e.printStackTrace();
                return "2";
            }

        }
    }
    //电力交易结算删除
    @RequestMapping("Delete")
    @ResponseBody
    public String Delete(Integer id){

        try {
            dealService.Delete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //电力交易结算批删
    @RequestMapping("BatchDelete")
    @ResponseBody
    public String BatchDelete(String [] id){

        try {
            dealService.BatchDelete(id);
            return "1";
        } catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }
    //电力交易结算查询
    @RequestMapping("Query")
    @ResponseBody
    public Map Query(@RequestBody ParamUtil param){
        return  dealService.Query(param);
    }
}
