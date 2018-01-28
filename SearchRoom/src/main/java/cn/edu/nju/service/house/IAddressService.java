package cn.edu.nju.service.house;

import cn.edu.nju.service.ServiceMultiResult;
import cn.edu.nju.web.dto.SubwayDTO;
import cn.edu.nju.web.dto.SubwayStationDTO;
import cn.edu.nju.web.dto.SupportAddressDTO;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/28.
 * 地址服务接口
 */
public interface IAddressService {

    /**
     * 获取所有支持的城市列表
     * @return
     */
    ServiceMultiResult<SupportAddressDTO> findAllCities();

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     * @param cityName
     * @return
     */
    ServiceMultiResult findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市所有的地铁线路
     * @param cityEnName
     * @return
     */
    List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路所有的站点
     * @param subwayId
     * @return
     */
    List<SubwayStationDTO> findAllStationBySubway(Long subwayId);
}
