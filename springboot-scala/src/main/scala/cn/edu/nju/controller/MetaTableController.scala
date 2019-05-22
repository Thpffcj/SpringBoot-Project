package cn.edu.nju.controller

import cn.edu.nju.domain.MetaTable
import cn.edu.nju.service.MetaTableService
import cn.edu.nju.utils.ResultVOUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, ModelAttribute, PostMapping, RequestMapping, ResponseBody, RestController}

/**
  * Created by thpffcj on 2019-05-22.
  */
@RestController
@RequestMapping(Array("/meta/table"))
class MetaTableController @Autowired()(metaTableService: MetaTableService) {

  @PostMapping(value = Array("/"))
  @ResponseBody
  def save(@ModelAttribute metaTable:MetaTable) = {
    metaTableService.save(metaTable)
    // Scala调用已有的Java代码
    ResultVOUtil.success()
  }

  @GetMapping(value = Array("/"))
  def query() = {
    ResultVOUtil.success(metaTableService.query())
  }
}
