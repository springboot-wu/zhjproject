package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/30 14:18
 * @description：代理商
 * @package ：com.zhj.model
 * @version:
 */
public class Agent implements Serializable {
    private static final long serialVersionUID = 5280076453444086277L;
    private  Integer id;//主键
    private  String  agent;//代理商
    private  String  agentnumber;//代理商电话

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }


    public String getAgentnumber() {
        return agentnumber;
    }

    public void setAgentnumber(String agentnumber) {
        this.agentnumber = agentnumber;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", agent='" + agent + '\'' +
                ", agentnumber='" + agentnumber + '\'' +
                '}';
    }
}
