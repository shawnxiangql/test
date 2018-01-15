package com.xql.test.consumer

import java.util.Properties

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.{Component, Service}

/**
  * Created by xql on 18-1-15.
  */

@Component
class KafkaConsumerConfig {

  var consumerCount: Int = _
  var topic: String = _
  var consumerConfig: Map[String, String] = Map()

  @Value("${kafka.consumer.properties}")
  def initConsumerProp(prop: String): Unit = {
    println(prop)
    val gson = new Gson()
    val map = gson.fromJson(prop, classOf[KafkaConsumerConfig])


  }

  def prop: Properties = {
    checkConfig()
    val properties = defaultProperty()
    consumerConfig.foreach((entry) => properties.setProperty(entry._1, entry._2))
    properties
  }

  private def defaultProperty(): Properties = {
    val properties = new Properties
    properties.setProperty(ConsumerConsts.GROUP_ID, this.topic + ConsumerConsts.DEFAULT_CONSUMER_GROUP_SUFFIX);
    properties.setProperty(ConsumerConsts.ENABLE_AUTO_COMMIT, ConsumerConsts.DEFAULT_ENABLE_AUTO_COMMIT);
    properties.setProperty(ConsumerConsts.SESSION_TIMEOUT_MS, ConsumerConsts.DEFAULT_SESSION_TIMEOUT_MS);
    properties.setProperty(ConsumerConsts.REQUEST_TIMEOUT_MS, ConsumerConsts.DEFAULT_REQUEST_TIMEOUT_MS);
    properties.setProperty(ConsumerConsts.MAX_PARTITION_FETCH_BYTES, ConsumerConsts.DEFAULT_MAX_PARTITION_FETCH_BYTES);
    properties.setProperty(ConsumerConsts.KEY_DESERIALIZE, ConsumerConsts.DEFAULT_DESERIALIZE);
    properties.setProperty(ConsumerConsts.VALUE_DESERIALIZE, ConsumerConsts.DEFAULT_DESERIALIZE);
    properties.setProperty(ConsumerConsts.AUTO_OFFSET_RESET, ConsumerConsts.DEFAULT_AUTO_OFFSET_RESET);
    properties
  }

  private def checkConfig(): Unit = {
    check(consumerConfig.isEmpty, "config is empty: kafka.consumer.properties -> consumerConfig")
    check(consumerConfig.get(ConsumerConsts.BOOTSTRAP_SERVERS).isEmpty,
      "config error: kafka.consumer.properties -> consumerConfig -> bootstrap.servers");
    check(consumerConfig(ConsumerConsts.ENABLE_AUTO_COMMIT).isEmpty ||
      consumerConfig(ConsumerConsts.ENABLE_AUTO_COMMIT).toBoolean,
      "config error: kafka.consumer.properties -> consumerConfig -> enable.auto.commit");
    check(topic.length == 0, "config error: kafka.consumer.properties -> topic");
  }

  private def check(condition: Boolean, message: String): Unit = if (condition) throw new RuntimeException(message)

}
