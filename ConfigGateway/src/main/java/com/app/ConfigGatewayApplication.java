package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/order/**")
						.filters(f -> f.rewritePath("/accounts/(?<segment>.*)", "/${segment}")
								//.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
						)
						.uri("lb://ORDERSERVICE"))
				.route(p -> p.path("/product/**")
						.filters(f -> f.rewritePath("/product/(?<segment>.*)", "/${segment}")
								//.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
						)
						.uri("lb://PRODUCTSERVICE"))
				.route(p -> p.path("/payment/**")
						.filters(f -> f.rewritePath("/payment/(?<segment>.*)", "/${segment}")
								//.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
						)
						.uri("lb://PAYMENTSERVICE"))
				.build();

	}
}
