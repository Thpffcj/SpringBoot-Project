package cn.edu.nju.service

import cn.edu.nju.domain.MetaTable
import cn.edu.nju.repository.MetaTableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by thpffcj on 2019-05-22.
  */
@Service
class MetaTableService @Autowired()(metaTableRepository: MetaTableRepository) {

  @Transactional
  def save(metaTable: MetaTable) = {
    metaTableRepository.save(metaTable)
  }

  def query() = {
    metaTableRepository.findAll()
  }

}
