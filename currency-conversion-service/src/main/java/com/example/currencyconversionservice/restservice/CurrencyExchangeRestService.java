/**
 *
 */
package com.example.currencyconversionservice.restservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.model.CurrencyConversion;

/**
 * @author virens
 *
 */

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeRestService {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
