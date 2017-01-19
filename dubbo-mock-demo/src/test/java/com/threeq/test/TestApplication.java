package com.threeq.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Date 2017/1/19
 * @User three
 */
@EnableAutoConfiguration
@Configuration
@ImportResource("classpath:dubbo_consumer.xml")
public class TestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestApplication.class, args);
    }
}
