package cn.edu.nju.service;

import cn.edu.nju.vo.City;

import java.util.List;

/**
 * Created by Thpffcj on 2018/2/4.
 */
public interface CityDataService {

    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
