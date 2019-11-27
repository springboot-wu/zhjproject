package com.zhj.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 18:01
 * @description：部门表
 * @package ：com.zhj.model
 * @version:
 */
@Builder
public class Department implements Serializable {
    private static final long serialVersionUID = 8983013826319672879L;
    private  Integer id; //主键
    private  String department; //部门名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
