package cn.edu.nju.service.search;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thpffcj on 2018/1/31.
 * 百度位置信息
 */
public class BaiduMapLocation {

    // 经度
    @JsonProperty("lon")
    private double longitude;

    // 纬度
    @JsonProperty("lat")
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
