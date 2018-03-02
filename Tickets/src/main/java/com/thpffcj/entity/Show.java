package com.thpffcj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Entity
@Table(name = "show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Column(name = "performance_time")
    private Date performanceTime;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
