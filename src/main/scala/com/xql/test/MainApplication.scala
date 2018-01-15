package com.xql.test

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

/**
  * Created by xql on 18-1-15.
  */
@SpringBootApplication
class MainApplication

object MainApplication extends App {
  new SpringApplicationBuilder().sources(classOf[MainApplication]).child(classOf[MainApplication]).run()
//  SpringApplication.run(classOf[MainApplication])
}
