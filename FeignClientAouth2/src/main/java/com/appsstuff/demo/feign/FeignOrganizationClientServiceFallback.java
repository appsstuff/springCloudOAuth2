package com.appsstuff.demo.feign;

import org.springframework.stereotype.Component;

import com.appsstuff.demo.service.Organaziation;

@Component
public class FeignOrganizationClientServiceFallback implements FeignOrganizationClientService {

	@Override
    public Organaziation getOrganization(String orgId) {
		 Organaziation org = new Organaziation();
		 org.setOrgName("Organazation Client is busy or disconnected, Please try latter");
		 return org;
	}
}
