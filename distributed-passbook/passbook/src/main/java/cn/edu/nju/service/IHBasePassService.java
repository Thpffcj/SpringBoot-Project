package cn.edu.nju.service;

import cn.edu.nju.vo.PassTemplate;

/**
 * Pass HBase 服务
 * Created by thpffcj on 2019-05-07.
 */
public interface IHBasePassService {

    /**
     * 将 PassTemplate 写入 HBase
     *
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
