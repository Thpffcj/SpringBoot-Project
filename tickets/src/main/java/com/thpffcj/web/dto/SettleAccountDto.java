package com.thpffcj.web.dto;

import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/12.
 */
public class SettleAccountDto {

    private String venueName;
    private String showName;
    private Date performanceTime;
    private double totalBenefit;
    private double ratio;
    private double settlementAmount;
    private int status;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Date getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(Date performanceTime) {
        this.performanceTime = performanceTime;
    }

    public double getTotalBenefit() {
        return totalBenefit;
    }

    public void setTotalBenefit(double totalBenefit) {
        this.totalBenefit = totalBenefit;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
