package com.xql.test.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener

/**
  * Created by xql on 18-1-15.
  */

class KafkaMessageListener {

  @Autowired var consumerConfiguration: ConsumerConfiguration = _

  @KafkaListener(topics = Array(consumerConfiguration.kafkaConsumerConfig.topic),
    groupId = "group1")
  def listen(record: java.util.List[ConsumerRecord[String, String]]): Unit = {
    System.out.println(record)
  }

}
