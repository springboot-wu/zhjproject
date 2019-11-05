package com.zhj.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 17:59
 * @description：后台系统用户表
 * @package ：com.zhj.model
 * @version:
 */

public class User implements Serializable {
    private static final long serialVersionUID = 8281159851632066509L;
    private  Integer id;//主键
    private  String username; //账号
    private  String name; //姓名
    private  String phone;//电话
    private  String password;//密码
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date thistime;//本次登录时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private  Date  lasttime;//最后登录时间
    private  String  region;//登陆地址
    private  Integer accountstatus;//账号状态
    private  Integer departmentid;//部门关联id
    private  String department;//部门名称(零时字段)
    private  String rolename;//角色名称(零时字段)

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(Integer accountstatus) {
        this.accountstatus = accountstatus;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", thistime=" + thistime +
                ", lasttime=" + lasttime +
                ", region='" + region + '\'' +
                ", accountstatus=" + accountstatus +
                ", departmentid=" + departmentid +
                ", department='" + department + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
