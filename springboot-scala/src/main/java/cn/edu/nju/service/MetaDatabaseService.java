package cn.edu.nju.service;

import cn.edu.nju.domain.MetaDatabase;
import cn.edu.nju.reposiory.MetaDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thpffcj on 2019-05-22.
 */
@Service
public class MetaDatabaseService {

    @Autowired
    private MetaDatabaseRepository metaDatabaseRepository;

    @Transactional
    public void save(MetaDatabase metaDatabase) {
        metaDatabaseRepository.save(metaDatabase);
    }

    public Iterable<MetaDatabase> query() {
        return metaDatabaseRepository.findAll();
    }
}
