package com.servicio.carrito_de_compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CarritoDeComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoDeComprasApplication.class, args);
	}

}
