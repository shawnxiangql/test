package com.xql.test.consumer

import scala.collection.mutable.ArrayBuffer

/**
  * Created by xql on 18-1-15.
  */
class ConsumerManager extends Runnable {

  private var kafkaConsumerConfig: KafkaConsumerConfig = _
  private val kafkaConsumers = ArrayBuffer[KafkaMessageConsumer]()
  private var processor = null
  private var enable = false
  private var started = false
  private var config = null

  def run(): Unit = {
    started = true
    consumerStarted()
  }

  private def consumerStarted(): Unit = {
    kafkaConsumers.foreach {
      (consumer) => {
        //        consumer.setConfig(kafkaConsumerConfig)
        //        consumer.setEnable(enable)
        //        consumer.setStarted(started)
      }
    }
  }

//  private def changeKafkaConsumer(): Unit = {
//    val newConfig = parseConfig(config)
//    newConfig.checkConfig
//    val oldConfig = kafkaConsumerConfig
//    if (newConfig.equals(oldConfig)) return
//    kafkaConsumerConfig = newConfig
//    if (oldConfig == null || !Objects.equals(newConfig.getProp, oldConfig.getProp) || !Objects.equals(newConfig.getTopic, oldConfig.getTopic)) rebuildConsumer()
//    else if (!Objects.equals(newConfig.getConsumerCount, oldConfig.getConsumerCount)) changeConsumerCount(newConfig.getConsumerCount, oldConfig.getConsumerCount)
//  }
//
//  def parseConfig(configJson: String): Nothing = {
//    if (StringUtils.isEmpty(configJson)) return compatibleOldConfig
//    try {
//      val jsonObj = JSON.deserialize(new StringReader(configJson))
//      JSON.toJavaObject(jsonObj, classOf[Nothing]).asInstanceOf[Nothing]
//    } catch {
//      case e: Exception =>
//        throw new IllegalArgumentException("invalid config for kafka consumer", e)
//    }
//  }
//
//  private def compatibleOldConfig = {
//    val config = ApplicationConfiguration.get
//    val kafkaConsumerConfig = new Nothing
//    kafkaConsumerConfig.setConsumerCount(2)
//    kafkaConsumerConfig.setTopic(config.getString("kafka.consumer.topic"))
//    val consumerConfig = kafkaConsumerConfig.getConsumerConfig
//    consumerConfig.put(ConsumerConst.BOOTSTRAP_SERVERS, config.getString("kafka.consumer.bootstrap.servers"))
//    consumerConfig.put(ConsumerConst.GROUP_ID, config.getString("kafka.consumer.group.id"))
//    consumerConfig.put(ConsumerConst.ENABLE_AUTO_COMMIT, config.getString("kafka.consumer.enable.auto.commit"))
//    consumerConfig.put(ConsumerConst.SESSION_TIMEOUT_MS, config.getString("kafka.consumer.session.timeout.ms"))
//    consumerConfig.put(ConsumerConst.REQUEST_TIMEOUT_MS, config.getString("kafka.consumer.request.timeout.ms"))
//    consumerConfig.put(ConsumerConst.MAX_PARTITION_FETCH_BYTES, config.getString("kafka.consumer.max.partition.fetch.bytes"))
//    consumerConfig.put(ConsumerConst.KEY_DESERIALIZE, config.getString("kafka.consumer.key.deserializer"))
//    consumerConfig.put(ConsumerConst.VALUE_DESERIALIZE, config.getString("kafka.consumer.value.deserializer"))
//    consumerConfig.put(ConsumerConst.POLL_TIMEOUT_MS, config.getString("kafka.consumer.poll.timeout.ms"))
//    val reporterConfig = kafkaConsumerConfig.getReporterConfig
//    reporterConfig.put(ConsumerConst.MAX_PARTITION_FETCH_BYTES, config.getString("kafka.consumer.offset.report.max.fetch.bytes"))
//    kafkaConsumerConfig
//  }
//
//  private def createKafkaMessageConsumer(threadName: String) = {
//    val kafkaMessageConsumer = getKafkaMessageConsumer
//    kafkaMessageConsumer.setConfig(kafkaConsumerConfig)
//    kafkaMessageConsumer.setParser(parser)
//    kafkaMessageConsumer.setMessageGroup(messageGroup)
//    kafkaMessageConsumer.setProcessor(processor)
//    kafkaMessageConsumer.setThreadName(threadName)
//    kafkaMessageConsumer
//  }
//
//  def getKafkaMessageConsumer = new Nothing
//
//  private def removeLast(): Unit = {
//    val consumer = kafkaConsumers.get(kafkaConsumers.size - 1)
//    consumer.setEnable(false)
//    kafkaConsumers.remove(kafkaConsumers.size - 1)
//  }
//
//  private def rebuildConsumer(): Unit = {
//    kafkaConsumers.forEach((kafkaMessageConsumer: Nothing) => kafkaMessageConsumer.setStarted(false))
//    kafkaConsumers.clear()
//    var i = 1
//    while ( {
//      i <= kafkaConsumerConfig.getConsumerCount
//    }) {
//      kafkaConsumers.add(createKafkaMessageConsumer(ConsumerConst.CONSUMER_THREAD_PREFIX + i))
//
//      {
//        i += 1;
//        i - 1
//      }
//    }
//    consumerStarted()
//  }
//
//  private def changeConsumerCount(newCount: Integer, oldCount: Integer): Unit = {
//    val changeCount = newCount - oldCount
//    if (changeCount > 0) {
//      var i = 1
//      while ( {
//        i <= changeCount
//      }) {
//        val consumer = createKafkaMessageConsumer(ConsumerConst.CONSUMER_THREAD_PREFIX + (oldCount + i))
//        consumer.setEnable(enable)
//        kafkaConsumers.add(consumer)
//
//        {
//          i += 1;
//          i - 1
//        }
//      }
//      consumerStarted()
//    }
//    else if (changeCount < 0) {
//      var i = 0
//      while ( {
//        i > changeCount
//      }) {
//        removeLast()
//
//        {
//          i -= 1;
//          i + 1
//        }
//      }
//    }
//  }
//
//  @Config(ConsumerConst.CONSUMER_ENABLE) def setEnable(enable: Boolean): Unit = {
//    if (enable != this.enable) {
//      this.enable = enable
//      kafkaConsumers.forEach((consumer: Nothing) => consumer.setEnable(this.enable))
//    }
//  }
//
//  @Config(ConsumerConst.KAFKA_CONSUMER_PROPERTIES) def setConfig(config: String): Unit = {
//    this.config = config
//    changeKafkaConsumer()
//  }
//
//  def getConfig: Nothing = kafkaConsumerConfig
//
//  def setParser(parser: Nothing): Unit = {
//    this.parser = parser
//  }
//
//  def setMessageGroup(messageGroup: Nothing): Unit = {
//    this.messageGroup = messageGroup
//  }
//
//  def setProcessor(processor: Nothing): Unit = {
//    this.processor = processor
//  }

}

