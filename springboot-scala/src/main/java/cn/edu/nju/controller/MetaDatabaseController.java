package cn.edu.nju.controller;

import cn.edu.nju.domain.MetaDatabase;
import cn.edu.nju.service.MetaDatabaseService;
import cn.edu.nju.utils.ResultVO;
import cn.edu.nju.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thpffcj on 2019-05-22.
 */
@RestController
@RequestMapping("/meta/database")
public class MetaDatabaseController {

    @Autowired
    private MetaDatabaseService metaDatabaseService;

    @PostMapping("/")
    public ResultVO save(@ModelAttribute MetaDatabase metaDatabase) {
        metaDatabaseService.save(metaDatabase);
        return ResultVOUtil.success();
    }

    @GetMapping("/")
    public ResultVO query() {
        return ResultVOUtil.success(metaDatabaseService.query());
    }
}
