package com.openshift.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/service1")
public class Service1Controller {

	@Autowired
	RestTemplate restTemplate;
	
	String service1_product_url="http://localhost:8081/products";
	
	@GetMapping("/info")
	public String welcome() {
		return "++++++++++++++++++++++++++++  -: Welcome to Service 1 :- +++++++++++++++++++++++++++++++++ ";
	}
	
	
	@RequestMapping(value = "/getProductsList", method = RequestMethod.GET)	
	public List<Object> getProducts() {	 
		
	ResponseEntity<Object[]> response = restTemplate.getForEntity(service1_product_url, Object[].class);
	return Arrays.asList(response.getBody());
	
	}
	
	
	
}
