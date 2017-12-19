package service;

import bean.Dic;

import java.util.List;

/**
 * Created by Thpffcj on 2017/9/25.
 */
public interface DicService {
    /**
     * 根据类型获取字典表列表
     * @param type 类型
     * @return 字典表列表
     */
    public List<Dic> getListByType(String type);
}