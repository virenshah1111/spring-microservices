/**
 *
 */
package com.example.apigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @author virens
 *
 */

@Component
public class LoggingFilter implements GlobalFilter {

	final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Request------> " + exchange.getRequest().getPath());
		System.out.println("Request------> " + exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
