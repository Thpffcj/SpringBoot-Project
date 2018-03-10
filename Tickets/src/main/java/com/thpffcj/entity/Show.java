package com.thpffcj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "venue_id")
    private Long venueId;
    private String name;
    private String type;
    @Column(name = "performance_time")
    private Date performanceTime;
    private String description;
    private String img;

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

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", venueId=" + venueId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", performanceTime=" + performanceTime +
                ", description='" + description + '\'' +
                '}';
    }
}
