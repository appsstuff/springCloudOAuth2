package com.appsstuff.demo.feign;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.filter.RequestContextFilter;

import brave.sampler.Sampler;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
@EnableOAuth2Client
@EnableHystrix
public class FeignConfig {

	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}


	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {

		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
				requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());
			}
		};
	}

	@Bean
	public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(OAuth2ClientContext context,
			OAuth2ProtectedResourceDetails resource) {
		return new OAuth2FeignRequestInterceptor(context, resource);
	}

	@Bean
	public RequestContextFilter requestContextFilter() {
		return new RequestContextFilter();
	}
}
