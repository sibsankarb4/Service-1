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
	
	@Value("${service2.product-url}")
        private String service2_product_url;
	//String service2_product_url="https://service-2-sibsber1-23934.osc-sbx-exp-ap-56325c34021cf286d0e188cc291cdca2-0001.us-east.containers.appdomain.cloud/Service-2-v1/service2/products";
	
	@GetMapping("/info")
	public String welcome() {
		return "++++++++++++++++++++++++++++  -: Welcome to Service 1 :- +++++++++++++++++++++++++++++++++ ";
	}
	
	
	@RequestMapping(value = "/getProductsList", method = RequestMethod.GET)	
	public List<Object> getProducts() {	 
		
	ResponseEntity<Object[]> response = restTemplate.getForEntity(service2_product_url, Object[].class);
	return Arrays.asList(response.getBody());
	
	}
	
	
	
}
