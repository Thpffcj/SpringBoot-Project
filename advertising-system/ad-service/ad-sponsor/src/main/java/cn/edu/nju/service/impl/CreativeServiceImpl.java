package cn.edu.nju.service.impl;

import cn.edu.nju.dao.CreativeRepository;
import cn.edu.nju.entity.Creative;
import cn.edu.nju.service.ICreativeService;
import cn.edu.nju.vo.CreateUserResponse;
import cn.edu.nju.vo.CreativeRequest;
import cn.edu.nju.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thpffcj on 2019/9/6.
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
              request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
