package com.ecart.gatewayserver;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	  
	@Bean
	public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
						.route(p -> p
								.path("/ecart/products/**")
								.filters( f -> f.rewritePath("/ecart/products/(?<segment>.*)","/${segment}")
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
										.circuitBreaker(config->config.setName("accountsCircuitBreaker")))
								.uri("lb://PRODUCTS"))
					.route(p -> p
							.path("/ecart/customer/**")
							.filters( f -> f.rewritePath("/ecart/customer/(?<segment>.*)","/${segment}")
									.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
							.uri("lb://CUSTOMER"))
					.route(p -> p
							.path("/ecart/sales-order/**")
							.filters( f -> f.rewritePath("/ecart/sales-order/(?<segment>.*)","/${segment}")
									.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
							.uri("lb://SALES-ORDER")).build();


	}
}
