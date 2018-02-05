package cn.edu.nju.service;

/**
 * Created by Thpffcj on 2018/2/4.
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    void syncDateByCityId(String cityId);
}
