package gview.usergardenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@EnableAutoConfiguration
@ComponentScan
@Configuration
public class ClientGardenServiceAppConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientGardenServiceAppConfig.class, args);
    }



}
