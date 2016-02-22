package gview.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ClientServiceAppConfig {
	
	public  void main(String[] args) {
	        SpringApplication.run(ClientServiceAppConfig.class, args);
	    }
	}

