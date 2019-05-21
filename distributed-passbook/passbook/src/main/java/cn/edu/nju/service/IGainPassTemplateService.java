package cn.edu.nju.service;

import cn.edu.nju.vo.GainPassTemplateRequest;
import cn.edu.nju.vo.Response;

/**
 * 用户领取优惠券功能实现
 * Created by thpffcj on 2019-05-08.
 */
public interface IGainPassTemplateService {

    /**
     * 用户领取优惠券
     *
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
