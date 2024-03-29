package br.com.alura.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
 /*Micro serviçoes com Eureka server*/
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
