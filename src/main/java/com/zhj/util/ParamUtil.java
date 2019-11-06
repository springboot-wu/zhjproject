package com.zhj.util;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/25 10:07
 * @description：参数表
 * @package ：com.zhj.util
 * @version:
 */
public class ParamUtil implements Serializable {
    private static final long serialVersionUID = -4197018069962144100L;
   private  Integer page;//当前页
    private  Integer size;//每页条数
    private  String enterprise;//公众号企业名称
    private  String name;//公众号名称
    private  Integer status;//公众号类型
    private  Integer statu;//申报类型
    private  String customername;//交易结算企业名称
    private  String department;//后台用户部门
    private  String username;//后台用户名称
    private  Integer salesman;//销售负责人
    private  Integer agent;//代理商
    private  Integer trader;//交易员
    private  Integer id;//公众号修改状态id
    private  Integer state;//是否启用
    private  Integer sort;//排序
    private String time;//时间

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesman() {
        return salesman;
    }

    public void setSalesman(Integer salesman) {
        this.salesman = salesman;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public Integer getTrader() {
        return trader;
    }

    public void setTrader(Integer trader) {
        this.trader = trader;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
