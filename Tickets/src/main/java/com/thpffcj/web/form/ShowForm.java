package com.thpffcj.web.form;

import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class ShowForm {

    private String name;
    private String type;
    private String performanceTime;
    private String description;

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

    public String getPerformanceTime() {
        return performanceTime;
    }

    public void setPerformanceTime(String performanceTime) {
        this.performanceTime = performanceTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ShowForm{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", performanceTime=" + performanceTime +
                ", description='" + description + '\'' +
                '}';
    }
}
