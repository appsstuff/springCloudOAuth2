package com.appsstuff.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appsstuff.demo.feign.FeignOrganizationClientService;

@Service
public class OrganizationClientService {
	
	@Autowired
	private FeignOrganizationClientService feignOrganizationClientServiceImpl;

	public Organaziation getOrganization(String organizationId) {
	 return feignOrganizationClientServiceImpl.getOrganization(organizationId);
	     }
	
	public String getLicenses(String organizationId)  {
	 return "Connected ......:  " + organizationId;
	     }
	
}
