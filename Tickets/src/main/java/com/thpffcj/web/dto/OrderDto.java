package com.thpffcj.web.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class OrderDto implements Serializable {

    private Long id;
    private String showName;
    private String venueName;
    private Date showTime;
    private String seatName;
    private int number;
    private double total;
    private double discount;
    private Date orderTime;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", showName='" + showName + '\'' +
                ", venueName='" + venueName + '\'' +
                ", showTime=" + showTime +
                ", seatName='" + seatName + '\'' +
                ", number=" + number +
                ", total=" + total +
                ", discount=" + discount +
                ", orderTime=" + orderTime +
                ", status=" + status +
                '}';
    }
}
