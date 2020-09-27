package com.osvue.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * hzqq110@163.com thank you for ever
 */
@MapperScan(basePackages = {"com.osvue.example.mapper","com.osvue.example.quartz.mapper"})
@SpringBootApplication
public class ExampleApplication {

  public static void main(String[] args) {

    SpringApplication.run(ExampleApplication.class, args);
  }



  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
