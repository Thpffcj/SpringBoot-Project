package cn.edu.nju.domain

import javax.persistence.{Entity, GeneratedValue, Id, Table}

import scala.beans.BeanProperty

/**
  * Created by thpffcj on 2019-05-22.
  */
@Entity
@Table
class MetaTable {

  @Id
  @GeneratedValue
  @BeanProperty
  var id:Integer = _

  @BeanProperty
  var name:String = _

  @BeanProperty
  var tableType:String = _

  @BeanProperty
  var dbId:Integer = _
}
