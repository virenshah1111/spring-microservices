/**
 *
 */
package com.example.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.model.CurrencyExchange;
import com.example.currencyexchangeservice.service.CurrencyExchangeService;

/**
 * @author virens
 *
 */

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return currencyExchangeService.retrieveExchangeValue(from, to);
	}

}
