package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/23 9:08
 * @description：客户表
 * @package ：com.zhj.model
 * @version:
 */
public class Client implements Serializable {
    private static final long serialVersionUID = -8796712011181718822L;
    private  Integer id; //主键
    private  Integer province;//省份
    private  Integer customername; //客户名称
    private  Integer typeid; //用户类型id
    private  Integer traderid;//交易员id
    private  Integer agentid; //代理商id
    private  Integer salesmanid;//销售负责人id
    private  Integer trader; //交易员(零时字段)
    private  Integer traderphone; //交易电话(零时字段)
    private  Integer salesman; //销售负责人(零时字段)
    private  Integer salescalls; //销售电话(零时字段)
    private  Integer agent; //代理商(零时字段)
    private  Integer agentnumber; //代理商电话(零时字段)
    private  String typename;//类型名称(零时使用字段)

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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCustomername() {
        return customername;
    }

    public void setCustomername(Integer customername) {
        this.customername = customername;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getTrader() {
        return trader;
    }

    public void setTrader(Integer trader) {
        this.trader = trader;
    }

    public Integer getTraderphone() {
        return traderphone;
    }

    public void setTraderphone(Integer traderphone) {
        this.traderphone = traderphone;
    }

    public Integer getSalesman() {
        return salesman;
    }

    public void setSalesman(Integer salesman) {
        this.salesman = salesman;
    }

    public Integer getSalescalls() {
        return salescalls;
    }

    public void setSalescalls(Integer salescalls) {
        this.salescalls = salescalls;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public Integer getAgentnumber() {
        return agentnumber;
    }

    public void setAgentnumber(Integer agentnumber) {
        this.agentnumber = agentnumber;
    }

    public Integer getTraderid() {
        return traderid;
    }

    public void setTraderid(Integer traderid) {
        this.traderid = traderid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    public Integer getSalesmanid() {
        return salesmanid;
    }

    public void setSalesmanid(Integer salesmanid) {
        this.salesmanid = salesmanid;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", province=" + province +
                ", customername=" + customername +
                ", typeid=" + typeid +
                ", traderid=" + traderid +
                ", agentid=" + agentid +
                ", salesmanid=" + salesmanid +
                ", trader=" + trader +
                ", traderphone=" + traderphone +
                ", salesman=" + salesman +
                ", salescalls=" + salescalls +
                ", agent=" + agent +
                ", agentnumber=" + agentnumber +
                ", typename='" + typename + '\'' +
                '}';
    }
}
