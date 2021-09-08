/**
 *
 */
package com.example.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limitsservice.config.LimitServiceConfigProperties;
import com.example.limitsservice.model.Limits;

/**
 * @author virens
 *
 */

@RestController
public class LimitsController {

	@Autowired
	private LimitServiceConfigProperties limitServiceConfigProperties;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(limitServiceConfigProperties.getMinimum(), limitServiceConfigProperties.getMaximum());
	}

}
