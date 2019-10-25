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
    private  Integer rows;//每页条数
    private  String enterprise;//公众号企业名称
    private  String name;//公众号名称
    private  Integer status;//公众号类型
    private  Integer statu;//申报类型
    private  String customername;//交易结算企业名称
    private  String department;//后台用户部门
    private  String username;//后台用户名称
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
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
