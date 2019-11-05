package com.zhj.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:07
 * @description：电力交易结算表
 * @package ：com.zhj.model
 * @version:
 */
public class Deal implements Serializable {
    private static final long serialVersionUID = 1562364526537211258L;
    private Integer id;//主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date balancedate;//结算日 期
    private String customername;//客户名称
    private String area;//区域
    private double electric;//交易电量
    private double practical;//实际交易电量
    private double power;//偏差电量
    private double deviationratio;//偏差率
    private double assess;//考核执行偏差
    private double deviation;//偏差考核费用
    private double userfees;//用户偏差考核费用
    private double companyexpense;//代理公司考核费用
    private double discount;//优惠金额
    private double totaldiscount;//合计优惠金额
    private String remake;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBalancedate() {
        return balancedate;
    }

    public void setBalancedate(Date balancedate) {
        this.balancedate = balancedate;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getPractical() {
        return practical;
    }

    public void setPractical(double practical) {
        this.practical = practical;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getDeviationratio() {
        return deviationratio;
    }

    public void setDeviationratio(double deviationratio) {
        this.deviationratio = deviationratio;
    }

    public double getAssess() {
        return assess;
    }

    public void setAssess(double assess) {
        this.assess = assess;
    }

    public double getDeviation() {
        return deviation;
    }

    public void setDeviation(double deviation) {
        this.deviation = deviation;
    }

    public double getUserfees() {
        return userfees;
    }

    public void setUserfees(double userfees) {
        this.userfees = userfees;
    }

    public double getCompanyexpense() {
        return companyexpense;
    }

    public void setCompanyexpense(double companyexpense) {
        this.companyexpense = companyexpense;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(double totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", balancedate=" + balancedate +
                ", customername='" + customername + '\'' +
                ", area='" + area + '\'' +
                ", electric=" + electric +
                ", practical=" + practical +
                ", power=" + power +
                ", deviationratio=" + deviationratio +
                ", assess=" + assess +
                ", deviation=" + deviation +
                ", userfees=" + userfees +
                ", companyexpense=" + companyexpense +
                ", discount=" + discount +
                ", totaldiscount=" + totaldiscount +
                ", remake='" + remake + '\'' +
                '}';
    }
}
