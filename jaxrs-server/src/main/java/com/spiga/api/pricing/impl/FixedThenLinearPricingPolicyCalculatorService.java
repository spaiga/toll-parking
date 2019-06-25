package com.spiga.api.pricing.impl;

import com.spiga.api.pricing.PricingPolicyCalculatorService;

import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.PricingPolicy;

/**
 * The price is computed as a fixed amount plus an amount for each hour spent in the parking.
 * PS: as example, seconds are used instead of hours.
 * @author fspiga
 *
 */
public class FixedThenLinearPricingPolicyCalculatorService extends PricingPolicyCalculatorService {

	public Long computeAmount(Long timeSpentInSeconds, PricingPolicy pp) {
    	FixedThenLinearPricingPolicy fpp = (FixedThenLinearPricingPolicy)pp;
		Long amountLong = fpp.getFixedAmount().longValue() + (timeSpentInSeconds * fpp.getHourPrice().longValue());
		return amountLong;
	}

}
