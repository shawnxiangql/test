package com.xql.test.web

import com.xql.test.consumer.KafkaMessageConsumer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

/**
  * Created by xql on 18-1-15.
  */
@Controller
class HomePage {

  @Autowired var messageConsumer: KafkaMessageConsumer = _

  @RequestMapping(name = "/")
  @ResponseBody
  def hello(): String = "hello world "

}
