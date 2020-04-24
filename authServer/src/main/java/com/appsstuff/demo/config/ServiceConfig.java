package com.appsstuff.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ServiceConfig {
  @Value("${signing.key:345345fsdgsf5345}")
  private String jwtSigningKey;


  public String getJwtSigningKey() {
    return jwtSigningKey;
  }

}