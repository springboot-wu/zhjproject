package com.zhj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:37
 * @description：公众号用户表
 * @package ：com.zhj.model
 * @version:
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 5305705184587741422L;
    private  Integer  id;  //主键
    private  String  calculate;//账号
    private  String  name;//姓名
    private  String  cellphone;//手机号
    private  Integer  typeid;//类型id
    private  String  enterpriseid;//所属企业id
    private  String  password;//密码
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date thistime;//添加登陆时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private  Date lasttime;//最后登陆时间
    private  Integer  status;//是否启用 1是启用  2是不启用
    private  String typename;//类型名称(零时使用字段)
    private  String  customername;//所属企业(零时使用字段)
    private  String  traderphone;//交易原电话(零时字段)

    public String getTraderphone() {
        return traderphone;
    }

    public void setTraderphone(String traderphone) {
        this.traderphone = traderphone;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getThistime() {
        return thistime;
    }

    public void setThistime(Date thistime) {
        this.thistime = thistime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", calculate='" + calculate + '\'' +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", typeid=" + typeid +
                ", enterpriseid='" + enterpriseid + '\'' +
                ", password='" + password + '\'' +
                ", thistime=" + thistime +
                ", lasttime=" + lasttime +
                ", status=" + status +
                ", typename='" + typename + '\'' +
                ", customername='" + customername + '\'' +
                '}';
    }
}
