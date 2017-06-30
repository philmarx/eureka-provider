package com.study.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private final static Log log=LogFactory.getLog(HelloController.class);
	
	@Autowired
	DiscoveryClient client;
	
	@GetMapping("hello")
	public String index(){
		ServiceInstance instance=client.getLocalServiceInstance();
		String msg="/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId();
		log.info(msg);
		return msg;
	}
}
