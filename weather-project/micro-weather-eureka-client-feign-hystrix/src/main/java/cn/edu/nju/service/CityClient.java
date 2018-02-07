package cn.edu.nju.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Thpffcj on 2018/2/7.
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
