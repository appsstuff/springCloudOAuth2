package com.appsstuff.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
@EnableEurekaClient
@EnableDiscoveryClient
public class AuthServerApplication {


	 private static final Logger lOGGER = Logger.getLogger(AuthServerApplication.class.getName());

    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication aouth2) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", aouth2.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(aouth2.getUserAuthentication().getAuthorities()));
        return userInfo;
    }

	  @Bean
	    public Sampler alwaysSampler() {
	        return Sampler.ALWAYS_SAMPLE;
	    }
	 

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

}
