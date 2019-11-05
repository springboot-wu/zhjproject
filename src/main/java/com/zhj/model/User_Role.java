package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/23 11:49
 * @description：部门角色关联表
 * @package ：com.zhj.model
 * @version:
 */
public class User_Role implements Serializable {


    private static final long serialVersionUID = -9213225124368440318L;
    private Integer id;//主键
    private Integer roleid;//角色id
    private Integer userid;//用户id

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", userid=" + userid +
                '}';
    }
}
