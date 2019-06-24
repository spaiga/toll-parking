package com.spiga.api.pricing.impl;

import com.spiga.api.pricing.PricingPolicyCalculatorService;

import io.swagger.model.LinearPricingPolicy;
import io.swagger.model.PricingPolicy;

public class LinearPricingPolicyCalculatorService extends PricingPolicyCalculatorService {

	public Long computeAmount(Long timeSpentInSeconds, PricingPolicy pp) {
    	LinearPricingPolicy fpp = (LinearPricingPolicy)pp;
		Long amountLong = (timeSpentInSeconds * fpp.getHourPrice().longValue());
		return amountLong;
	}

}
