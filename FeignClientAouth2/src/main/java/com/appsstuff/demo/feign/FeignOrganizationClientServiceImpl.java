package com.appsstuff.demo.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.appsstuff.demo.service.Organaziation;

@Service
public class FeignOrganizationClientServiceImpl implements FeignOrganizationClientService {
	
	@Override
	public Organaziation getOrganization( @PathVariable("organizationId") String organizationId) {
	 return getOrganization(organizationId);
	   }
	
	public String getLicenses(@PathVariable("organizationId") String organizationId)  {
	 return "Connected ......:  " + organizationId;
	   }
	
}
