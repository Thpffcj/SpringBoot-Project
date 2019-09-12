package cn.edu.nju.service;

import cn.edu.nju.vo.CreativeRequest;
import cn.edu.nju.vo.CreativeResponse;

/**
 * Created by thpffcj on 2019/9/6.
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
