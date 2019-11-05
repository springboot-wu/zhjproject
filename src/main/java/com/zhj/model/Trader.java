package com.zhj.model;

import java.io.Serializable;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/30 14:02
 * @description：交易员
 * @package ：com.zhj.model
 * @version:
 */
public class Trader implements Serializable {
    private static final long serialVersionUID = -6725837445384046636L;
    private  Integer id;//主键
    private  String  trader;//交易员
    private  String  traderphone;//交易员电话

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getTraderphone() {
        return traderphone;
    }

    public void setTraderphone(String traderphone) {
        this.traderphone = traderphone;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", trader='" + trader + '\'' +
                ", traderphone='" + traderphone + '\'' +
                '}';
    }
}
