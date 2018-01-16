package com.xql.test.consumer

/**
  * Created by xql on 18-1-15.
  */
class KafkaConsumerConfig {

  var pollTimeout: Int = 1000
  var consumerCount: Int = 1
  var topic: String = ""
  var consumer: Map[String, String] = Map()

  def getConsumerConfig: Map[String, String] = {
    checkConfig()
    defaultConfig() ++ consumer
  }

  private def defaultConfig(): Map[String, String] = {
    Map[String, String](ConsumerConsts.GROUP_ID -> (topic + ConsumerConsts.DEFAULT_CONSUMER_GROUP_SUFFIX),
      ConsumerConsts.ENABLE_AUTO_COMMIT -> ConsumerConsts.DEFAULT_ENABLE_AUTO_COMMIT,
      ConsumerConsts.SESSION_TIMEOUT_MS -> ConsumerConsts.DEFAULT_SESSION_TIMEOUT_MS,
      ConsumerConsts.REQUEST_TIMEOUT_MS -> ConsumerConsts.DEFAULT_REQUEST_TIMEOUT_MS,
      ConsumerConsts.MAX_PARTITION_FETCH_BYTES -> ConsumerConsts.DEFAULT_MAX_PARTITION_FETCH_BYTES,
      ConsumerConsts.KEY_DESERIALIZE -> ConsumerConsts.DEFAULT_DESERIALIZE,
      ConsumerConsts.VALUE_DESERIALIZE -> ConsumerConsts.DEFAULT_DESERIALIZE,
      ConsumerConsts.AUTO_OFFSET_RESET -> ConsumerConsts.DEFAULT_AUTO_OFFSET_RESET)
  }

  private def checkConfig(): Unit = {
    check(consumer.isEmpty, "config is empty: kafka.consumer.properties -> consumerConfig")
    check(consumer.get(ConsumerConsts.BOOTSTRAP_SERVERS).isEmpty,
      "config error: kafka.consumer.properties -> consumerConfig -> bootstrap.servers");
    check(consumer(ConsumerConsts.ENABLE_AUTO_COMMIT).isEmpty ||
      consumer(ConsumerConsts.ENABLE_AUTO_COMMIT).toBoolean,
      "config error: kafka.consumer.properties -> consumerConfig -> enable.auto.commit");
    check(topic.length == 0, "config error: kafka.consumer.properties -> topic");
  }

  private def check(condition: Boolean, message: String): Unit = if (condition) throw new RuntimeException(message)
}
