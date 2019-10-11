package com.thpffcj.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Thpffcj on 2018/3/5.
 */
public class VenueFinanceDto implements Serializable {

    @JsonProperty(value = "venue_id")
    private Long venueId;
    @JsonProperty(value = "venue_name")
    private String venueName;
    @JsonProperty(value = "show_number")
    private int showNumber;
    @JsonProperty(value = "total_benefit")
    private double totalBenefit;

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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
