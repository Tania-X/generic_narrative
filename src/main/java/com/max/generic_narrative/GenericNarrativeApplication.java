package com.max.generic_narrative;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.max.generic_narrative.mapper")
@SpringBootApplication
public class GenericNarrativeApplication {

  public static void main(String[] args) {
    SpringApplication.run(GenericNarrativeApplication.class, args);
  }

}
