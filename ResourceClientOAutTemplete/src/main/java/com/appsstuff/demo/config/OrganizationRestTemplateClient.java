package com.appsstuff.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrganizationRestTemplateClient {

	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;
	
	
	private static final Logger logger =LoggerFactory.getLogger(OrganizationRestTemplateClient.class);
	
	public Organaziation getOrganization(String organizationId){
		 logger.debug("In Licensing Service getOrganization: {}",1);
		 ResponseEntity<Organaziation> restExchange =
		 
	 oAuth2RestTemplate.exchange(
		 "http://localhost:8800/api/org/v1/organizations/{organizationId}",
		 HttpMethod.GET,
		 null,
		 Organaziation.class,
		 organizationId);
		 return restExchange.getBody();
		 }		
}
