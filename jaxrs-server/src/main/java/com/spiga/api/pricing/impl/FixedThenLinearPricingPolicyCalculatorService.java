package com.spiga.api.pricing.impl;

import com.spiga.api.pricing.PricingPolicyCalculatorService;

import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.PricingPolicy;

public class FixedThenLinearPricingPolicyCalculatorService extends PricingPolicyCalculatorService {

	public Long computeAmount(Long timeSpentInSeconds, PricingPolicy pp) {
    	FixedThenLinearPricingPolicy fpp = (FixedThenLinearPricingPolicy)pp;
		Long amountLong = fpp.getFixedAmount().longValue() + (timeSpentInSeconds * fpp.getHourPrice().longValue());
		return amountLong;
	}

}
