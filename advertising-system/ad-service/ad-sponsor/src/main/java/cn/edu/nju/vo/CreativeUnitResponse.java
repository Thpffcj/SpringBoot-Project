package cn.edu.nju.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by thpffcj on 2019/9/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitResponse {

    private List<Long> ids;
}
