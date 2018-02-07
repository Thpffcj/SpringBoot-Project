package cn.edu.nju.service;

import cn.edu.nju.vo.City;
import cn.edu.nju.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Thpffcj on 2018/2/6.
 */
@FeignClient(name="msa-weather-eureka-client-zuul", fallback=DataClientFallback.class)
public interface DataClient {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
