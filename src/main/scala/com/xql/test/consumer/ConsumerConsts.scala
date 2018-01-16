package com.xql.test.consumer

/**
  * Created by xql on 18-1-15.
  */
object ConsumerConsts {
  val BOOTSTRAP_SERVERS = "bootstrap.servers"
  val ENABLE_AUTO_COMMIT = "enable.auto.commit"
  val GROUP_ID:String = "group.id"
  val SESSION_TIMEOUT_MS = "session.timeout.ms"
  val REQUEST_TIMEOUT_MS = "request.timeout.ms"
  val MAX_PARTITION_FETCH_BYTES = "max.partition.fetch.bytes"
  val KEY_DESERIALIZE = "key.deserializer"
  val VALUE_DESERIALIZE = "value.deserializer"
  val AUTO_OFFSET_RESET = "auto.offset.reset"

  val DEFAULT_SESSION_TIMEOUT_MS = "60000"
  val DEFAULT_REQUEST_TIMEOUT_MS = "120000"
  val DEFAULT_MAX_PARTITION_FETCH_BYTES = "10485760"
  val DEFAULT_DESERIALIZE = "org.apache.kafka.common.serialization.StringDeserializer"
  val DEFAULT_AUTO_OFFSET_RESET = "latest"
  val DEFAULT_REPORTER_MAX_FETCH_BYTES = "1048576"
  val DEFAULT_ENABLE_AUTO_COMMIT = "false"

  val DEFAULT_REPORTER_GROUP_ID_PREFIX = "report_"
  val DEFAULT_CONSUMER_GROUP_SUFFIX:String = "_consumer_group"
  val MAX_CONSUMER_COUNT = 100
  val DEFAULT_CONSUMER_COUNT = 2

}
