package com.appsstuff.demo.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appsstuff.demo.config.Organaziation;
import com.appsstuff.demo.config.OrganizationRestTemplateClient;

@RestController
@RequestMapping(value="/v1/organizations")
public class LicenseServiceController {
 
	 private static final Logger lOGGER = Logger.getLogger(LicenseServiceController.class.getName());

	@Autowired
    private OrganizationRestTemplateClient service;

     @RequestMapping(value="/lice/{organizationId}",method = RequestMethod.GET)
    public Organaziation getLicenses( @PathVariable("organizationId") String organizationId) {
 		lOGGER.info("Get Fienn-Client Service org ");
        return service.getOrganization(organizationId);
    }

   
     @RequestMapping(value="/lice2/{organizationId}",method = RequestMethod.GET)
     public Organaziation getLicenses2( @PathVariable("organizationId") String organizationId) {
    		Organaziation org = new Organaziation(20,"IBM","Egypt");
 	       return org;
     }

}
