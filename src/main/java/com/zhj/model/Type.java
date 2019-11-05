package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 17:55
 * @description：类型表
 * @package ：com.zhj.model
 * @version:
 */
public class Type implements Serializable {
    private static final long serialVersionUID = -7067296081748742367L;
    private  Integer id; //主键
    private  String  typename;//类型名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
