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
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {

        // 由天气数据API微服务来提供
        WeatherResponse resp = dataClient.getDataByCityId(cityId);
        Weather data = null;
        if (resp != null ) {
            resp.getData();
        }
        return data;
    }
}
