package com.consumer.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@GetMapping("/v3/call")
	public String process() {
		return "this is nagendra";	
	}

}
