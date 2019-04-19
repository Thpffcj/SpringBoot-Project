package cn.edu.nju.service;

import cn.edu.nju.vo.CreateMerchantsRequest;
import cn.edu.nju.vo.PassTemplate;
import cn.edu.nju.vo.Response;

/**
 * 对商户服务接口定义
 * Created by thpffcj on 2019-04-18.
 */
public interface IMerchantsService {

    /**
     * 创建商户服务
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据 id 构造商户信息
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * 投放优惠券
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
