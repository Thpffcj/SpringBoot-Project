package cn.edu.nju.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by thpffcj on 2019/8/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;

    private boolean validate() {
        return userId != null && !CollectionUtils.isEmpty(ids);
    }
}
