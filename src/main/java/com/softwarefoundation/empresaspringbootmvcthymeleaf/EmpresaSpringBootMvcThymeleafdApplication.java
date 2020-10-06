package com.softwarefoundation.empresaspringbootmvcthymeleaf;

import com.softwarefoundation.empresaspringbootmvcthymeleaf.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmpresaSpringBootMvcThymeleafdApplication {

	public static void main(String[] args) {
		SpringUtil.setRandom(5000,5100);
		ApplicationContext context = SpringApplication.run(EmpresaSpringBootMvcThymeleafdApplication.class, args);
		System.out.println("App: "+context.getApplicationName());
	}

}
