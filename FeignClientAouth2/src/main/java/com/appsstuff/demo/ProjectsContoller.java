package com.appsstuff.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appsstuff.demo.feign.FeignOrganizationClientService;
import com.appsstuff.demo.service.Organaziation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
@RequestMapping("/v1/feignclient")
public class ProjectsContoller {
	
	 private static final Logger lOGGER = Logger.getLogger(ProjectsContoller.class.getName());

	@Autowired
	private FeignOrganizationClientService feignOrganizationClientServiceImpl;
	
	@HystrixCommand
	@RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
	public Organaziation getLicenses2( @PathVariable("organizationId") String organizationId) {
		lOGGER.info("Get Fienn-Client Service org ");
	 return feignOrganizationClientServiceImpl.getOrganization(organizationId);
	     }
	
	 public Organaziation getOrganization(String organizationId) {
			 Organaziation org = new Organaziation();
			 org.setOrgName("Error : Organazation Client is busy or disconnected, Please try later");
			 return org;
		}
	
	@RequestMapping(value="/test/{organizationId}",method = RequestMethod.GET)
	public String getLicenses(@PathVariable("organizationId") String organizationId)  {
	 return "Connected ......:  " + organizationId;
	     }		
}
