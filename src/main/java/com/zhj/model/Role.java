package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 18:05
 * @description：角色表
 * @package ：com.zhj.model
 * @version:
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1220099726930222123L;
    private  Integer roleid;//主键
    private  String rolename;//角色名称

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
