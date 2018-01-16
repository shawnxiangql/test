package com.xql.test.consumer

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

import scala.collection.convert.WrapAsJava._

/**
  * Created by xql on 18-1-15.
  */
@Configuration
@EnableKafka
class ConsumerConfiguration {

  var kafkaConsumerConfig: KafkaConsumerConfig = _

  @Value("${kafka.consumer.properties}")
  def initConsumerProperty(property: String): Unit = {
    kafkaConsumerConfig = new Gson().fromJson(property, classOf[KafkaConsumerConfig])
  }

  @Bean def containerFactory(): ConcurrentKafkaListenerContainerFactory[String, String] = {
    import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
    val factory = new ConcurrentKafkaListenerContainerFactory[String, String]
    factory.setConsumerFactory(consumerFactory)
    factory.setConcurrency(kafkaConsumerConfig.consumerCount)
    factory.getContainerProperties.setPollTimeout(kafkaConsumerConfig.pollTimeout)
    factory
  }

  @Bean def consumerFactory: DefaultKafkaConsumerFactory[String, String] =
    new DefaultKafkaConsumerFactory[String, String](kafkaConsumerConfig.getConsumerConfig)

}
