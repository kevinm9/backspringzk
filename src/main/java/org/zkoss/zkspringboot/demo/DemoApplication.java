package org.zkoss.zkspringboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

	@GetMapping("/mvvm")
	public String mvvmExample() {
		return "mvvm";
	}

	@GetMapping("/resources")
	public String resourcesExample() {
		return "resources";
	}
	
	@GetMapping("/index")
	public String index() {
		return "nuevo";
	}
	
	@GetMapping("/app")
	public String aplicacion() {
		return "aplicacion";
	}
	
	
	

}
