package com.example.induccion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello-help")
	public String helloThere() {
		return "Hello there";
	}
}
