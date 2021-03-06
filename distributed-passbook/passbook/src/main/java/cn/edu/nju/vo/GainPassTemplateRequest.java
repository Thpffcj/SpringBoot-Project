package cn.edu.nju.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户领取优惠券的请求对象
 * Created by thpffcj on 2019-05-08.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {

    // 用户 id
    private Long userId;

    // PassTemplate 对象
    private PassTemplate passTemplate;
}
