package com.cogent.adminservice.controller;

import static com.cogent.adminservice.constants.WebResourceKeyConstants.BASE_API;
import static com.cogent.adminservice.constants.WebResourceKeyConstants.FETCH_ADMIN_BY_USERNAME;
import static com.cogent.adminservice.constants.WebResourceKeyConstants.SAVE;
import static com.cogent.adminservice.constants.WebResourceKeyConstants.SEARCH;
import static com.cogent.adminservice.constants.WebResourceKeyConstants.UPDATE;
import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.adminservice.dto.request.AdminRequestDTO;
import com.cogent.adminservice.dto.response.AdminResponseDTO;
import com.cogent.adminservice.dto.response.ResponseDTO;
import com.cogent.adminservice.service.AdminService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author smriti
 */
@RestController
@RequestMapping(value = BASE_API)
@Api(value = "{This is admin controller}")
public class AdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping(value = SAVE)
	@ApiOperation(value = "Save new admin")
	@ResponseBody
	public ResponseEntity<?> saveAdmin(@RequestBody AdminRequestDTO requestDTO) {
		adminService.saveAdmin(requestDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = SEARCH)
	@ApiOperation(value = "Search admin by given parameters in request")
	public ResponseEntity<?> searchAdmin(@ApiParam(value = "Parameter value is admin username")
										 @RequestBody AdminRequestDTO requestDTO) {
		AdminResponseDTO admin =adminService.searchAdmin(requestDTO); 
		return ok().body(admin);
	}
	
	@PostMapping(value = UPDATE)
	@ApiOperation(value = "Update admin information")
	public ResponseEntity<?> updateAdmin(@RequestBody AdminRequestDTO requestDTO) {
		return ok().body(adminService.updateAdmin(requestDTO));
	}
	
//	@GetMapping(value = FETCH_ALL_ADMINS)
//	@ApiOperation(value = "Fetch list of all active admins")
//	public ResponseEntity<?> fetchAllAdmins() {
//		return ok().body(adminService.fetchAllAdmins());
//	}
	
	
	@GetMapping(value = FETCH_ADMIN_BY_USERNAME)
	public ResponseEntity fetchAdminByUsername(@PathVariable("username") String username) {
		return ok(adminService.fetchAdminByUsername(username));
	}
	
	@GetMapping("/admins")
	public ResponseEntity<ResponseDTO> getAdminsToSendEmail() {
		return new ResponseEntity<>(adminService.adminsToSendEmails(), HttpStatus.OK);
	}
	
	
	@GetMapping("/sayHello/{name}")
	@HystrixCommand(fallbackMethod = "fallBackHello", commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"
			)
	})
	public String sayHello(@PathVariable("name") String name) {
		if (name.equalsIgnoreCase("hello"))
			throw new RuntimeException();
		return "success METHOD";
		
	}
	
	public String fallBackHello(String name) {
		return "fallback hello";
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world!!!";
	}
	
	
}
