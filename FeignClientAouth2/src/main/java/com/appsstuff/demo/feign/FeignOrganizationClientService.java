package com.appsstuff.demo.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appsstuff.demo.service.Organaziation;


@RibbonClient("orgServer")
@FeignClient(value = "orgServer", fallback = FeignOrganizationClientServiceFallback.class)
public interface FeignOrganizationClientService  {

	@RequestMapping(value="/v1/organizations/{organizationId}",method = RequestMethod.GET)
    public Organaziation getOrganization(@PathVariable("organizationId") String orgId);
	}