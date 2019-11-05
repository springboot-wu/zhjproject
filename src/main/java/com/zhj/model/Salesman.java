package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/30 14:16
 * @description：销售表
 * @package ：com.zhj.model
 * @version:
 */
public class Salesman implements Serializable {
    private static final long serialVersionUID = -8069140767960038312L;
    private  Integer id;//主键
    private  String salesman;//销售负责人
    private  String salescalls;//销售电话

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getSalescalls() {
        return salescalls;
    }

    public void setSalescalls(String salescalls) {
        this.salescalls = salescalls;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "id=" + id +
                ", salesman='" + salesman + '\'' +
                ", salescalls='" + salescalls + '\'' +
                '}';
    }
}
