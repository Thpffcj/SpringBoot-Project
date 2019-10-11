package cn.edu.nju.service;

import cn.edu.nju.exception.AdException;
import cn.edu.nju.vo.*;

/**
 * Created by thpffcj on 2019/8/28.
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
            throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
            throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
            throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;

}
