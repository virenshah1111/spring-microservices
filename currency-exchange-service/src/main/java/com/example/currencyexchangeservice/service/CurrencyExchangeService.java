/**
 *
 */
package com.example.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.currencyexchangeservice.model.CurrencyExchange;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;

/**
 * @author virens
 *
 */

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Autowired
	private Environment environment;

	public CurrencyExchange retrieveExchangeValue(final String from, final String to) {

		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

}
