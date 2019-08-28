package cn.edu.nju.service;

import cn.edu.nju.exception.AdException;
import cn.edu.nju.vo.AdUnitRequest;
import cn.edu.nju.vo.AdUnitResponse;

/**
 * Created by thpffcj on 2019/8/28.
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;
}
