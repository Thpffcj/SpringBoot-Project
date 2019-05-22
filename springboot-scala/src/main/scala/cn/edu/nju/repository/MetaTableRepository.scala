package cn.edu.nju.repository

import cn.edu.nju.domain.MetaTable
import org.springframework.data.repository.CrudRepository

/**
  * Created by thpffcj on 2019-05-22.
  */
trait MetaTableRepository extends CrudRepository[MetaTable, Integer] {

}
