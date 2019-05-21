package cn.edu.nju.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestMethod, RestController}

/**
  * Created by thpffcj on 2019-05-21.
  */
@RestController
class ScalaHelloBoot {

  @RequestMapping(value = Array("/sayScalaHello"), method = Array(RequestMethod.GET))
  def sayScalaHello() = {

    "Hello Scala Boot...."
  }
}
