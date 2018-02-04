package cn.edu.nju.service;

import cn.edu.nju.vo.Weather;
import cn.edu.nju.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Thpffcj on 2018/2/4.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService  weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }

}
