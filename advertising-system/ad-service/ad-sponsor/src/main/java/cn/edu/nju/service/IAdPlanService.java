package cn.edu.nju.service;

import cn.edu.nju.entity.AdPlan;
import cn.edu.nju.exception.AdException;
import cn.edu.nju.vo.AdPlanGetRequest;
import cn.edu.nju.vo.AdPlanRequest;
import cn.edu.nju.vo.AdPlanResponse;

import java.util.List;

/**
 * Created by thpffcj on 2019/8/26.
 */
public interface IAdPlanService {

    /**
     * 创建推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
