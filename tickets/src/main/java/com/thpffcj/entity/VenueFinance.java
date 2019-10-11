package com.thpffcj.entity;

import javax.persistence.*;

/**
 * Created by Thpffcj on 2018/3/5.
 */
@Entity
@Table(name = "venue_finance")
public class VenueFinance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "venue_id")
    private Long venueId;
    @Column(name = "show_number")
    private int showNumber;
    @Column(name = "total_benefit")
    private double totalBenefit;

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

    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public double getTotalBenefit() {
        return totalBenefit;
    }

    public void setTotalBenefit(double totalBenefit) {
        this.totalBenefit = totalBenefit;
    }
}
