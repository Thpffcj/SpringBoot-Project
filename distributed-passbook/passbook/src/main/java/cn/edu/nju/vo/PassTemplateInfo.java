package cn.edu.nju.vo;

import cn.edu.nju.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 优惠券模板信息
 * Created by thpffcj on 2019-05-08.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo {

    // 优惠券模板
    private PassTemplate passTemplate;

    // 优惠券对应的商户
    private Merchants merchants;
}
