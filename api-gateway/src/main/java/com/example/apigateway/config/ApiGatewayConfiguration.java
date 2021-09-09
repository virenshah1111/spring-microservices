/**
 *
 */
package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author virens
 *
 */

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
				.build();
	}
}
