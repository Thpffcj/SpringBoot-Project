package service.impl;

import bean.Dic;
import dao.DicDao;
import org.springframework.stereotype.Service;
import service.DicService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Thpffcj on 2017/9/25.
 */

@Service
public class DicServiceImpl implements DicService {

    @Resource
    private DicDao dicDao;

    @Override
    public List<Dic> getListByType(String type) {
        Dic dic = new Dic();
        dic.setType(type);
        return dicDao.select(dic);
    }
}
