/**
 *
 */
package com.example.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.currencyexchangeservice.model.CurrencyExchange;

/**
 * @author virens
 *
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
