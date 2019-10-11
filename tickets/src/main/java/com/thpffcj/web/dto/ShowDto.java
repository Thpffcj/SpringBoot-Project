package com.thpffcj.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class ShowDto implements Serializable {

    private Long id;
    @JsonProperty(value = "venue_id")
    private Long venueId;
    private String name;
    private String type;
    @JsonProperty(value = "performance_time")
    private Date performanceTime;
    private String description;
    private String img;
    private double benefit;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(Date performanceTime) {
        this.performanceTime = performanceTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getBenefit() {
        return benefit;
    }

    public void setBenefit(double benefit) {
        this.benefit = benefit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
