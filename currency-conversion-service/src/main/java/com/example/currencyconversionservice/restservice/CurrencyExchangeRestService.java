/**
 *
 */
package com.example.currencyconversionservice.restservice;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.model.CurrencyConversion;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * @author virens
 *
 */

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "api-gateway")
public interface CurrencyExchangeRestService {

	//	@Retry(name = "currencyExchange", fallbackMethod = "fallbackRetrieveExchangeValue")
	@CircuitBreaker(name = "currencyExchange", fallbackMethod = "fallbackRetrieveExchangeValue")
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

	default CurrencyConversion fallbackRetrieveExchangeValue(String from, String to, Exception ex) {
		System.out.println("in fallback method---------> " + from + " " + to);
		return new CurrencyConversion(0L, from, to, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0),
				"fallback");
	}

}
