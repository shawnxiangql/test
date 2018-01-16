package com.xql.test.consumer

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.listener.config.ContainerProperties

import scala.collection.convert.WrapAsJava._

/**
  * Created by xql on 18-1-15.
  */
@Configuration
@EnableKafka
class KafkaMessageConsumer {

  @Bean def container(): ConcurrentMessageListenerContainer[String, String] = {
    val container = new ConcurrentMessageListenerContainer[String, String](factory, properties)
    container.setConcurrency(consumerCount)
    container
  }

  @Bean def consumerCount = 1

  @Bean def properties(): ContainerProperties = {
    val containerProperties = new ContainerProperties("test")
    containerProperties.setMessageListener(messageListener)
    containerProperties
  }

  @Bean def topicPartions = {
    new ContainerProperties("test")
  }

  @Bean def messageListener = _

  @Bean def factory = {
    new DefaultKafkaConsumerFactory[String, String](Map[String, Object]())
  }
}
