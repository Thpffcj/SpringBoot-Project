package cn.edu.nju.service;

import cn.edu.nju.vo.Weather;

/**
 * Created by Thpffcj on 2018/2/4.
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
