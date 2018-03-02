package com.thpffcj.web.form;

import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class ShowForm {

    private String type;
    private Date performanceTime;
    private String description;

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
}
