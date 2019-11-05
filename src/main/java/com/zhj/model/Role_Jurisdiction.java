package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/23 11:50
 * @description：角色权限关联表
 * @package ：com.zhj.model
 * @version:
 */
public class Role_Jurisdiction implements Serializable {
    private static final long serialVersionUID = -5964786177624911233L;
    private  Integer id;//主键
    private  Integer roleid;//角色id
    private  Integer jurisdictionid;//权限id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getJurisdictionid() {
        return jurisdictionid;
    }

    public void setJurisdictionid(Integer jurisdictionid) {
        this.jurisdictionid = jurisdictionid;
    }

    @Override
    public String toString() {
        return "Role_Jurisdiction{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", jurisdictionid=" + jurisdictionid +
                '}';
    }
}
