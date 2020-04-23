package com.appsstuff.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appsstuff.demo.security.Organaziation;

@RestController
@RequestMapping("/v1/organizations")
public class WebController {

	 private static final Logger lOGGER = Logger.getLogger(WebController.class.getName());
	 
	@Autowired
	private Environment env; 
	
	@RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public String deleteOrganization( @PathVariable("organizationId") String orgId) {
	       return "Deleted ..........";
	    }
		
		@RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
	    @ResponseStatus(HttpStatus.OK)
	    public Organaziation getOrganization( @PathVariable("organizationId") String orgId) {
			lOGGER.info("Get Fiegn-Org Service org ");
			String port = env.getProperty("local.server.port");
			int  portId = Integer.parseInt(port);
			Organaziation org = new Organaziation(portId,"Oracle","United State");
	       return org;
	    }
}
