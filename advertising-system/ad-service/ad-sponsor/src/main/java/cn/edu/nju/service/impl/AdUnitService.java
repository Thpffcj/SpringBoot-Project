package cn.edu.nju.service.impl;

import cn.edu.nju.constant.Constants;
import cn.edu.nju.dao.AdPlanRepository;
import cn.edu.nju.dao.AdUnitRepository;
import cn.edu.nju.entity.AdPlan;
import cn.edu.nju.entity.AdUnit;
import cn.edu.nju.exception.AdException;
import cn.edu.nju.service.IAdUnitService;
import cn.edu.nju.vo.AdUnitRequest;
import cn.edu.nju.vo.AdUnitResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by thpffcj on 2019/8/28.
 */
@Slf4j
@Service
public class AdUnitService implements IAdUnitService {

    private final AdPlanRepository planRepository;
    private final AdUnitRepository unitRepository;

    @Autowired
    public AdUnitService(AdUnitRepository unitRepository, AdPlanRepository planRepository) {
        this.unitRepository = unitRepository;
        this.planRepository = planRepository;
    }

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        Optional<AdPlan> adPlan =
                planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdUnit oldAdUnit = unitRepository.findByPlanIdAndUnitName(
                request.getPlanId(), request.getUnitName()
        );
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        AdUnit newAdUnit = unitRepository.save(
                new AdUnit(request.getPlanId(), request.getUnitName(),
                        request.getPositionType(), request.getBudget())
        );

        return new AdUnitResponse(newAdUnit.getId(),
                newAdUnit.getUnitName());
    }
}
