package com.spiga.api.factories;

import com.spiga.api.pricing.PricingPolicyCalculatorService;
import com.spiga.api.pricing.impl.FixedThenLinearPricingPolicyCalculatorService;
import com.spiga.api.pricing.impl.LinearPricingPolicyCalculatorService;

import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.LinearPricingPolicy;
import io.swagger.model.PricingPolicy;

public class PricingPolicyCalculatorServiceFactory {

    public static PricingPolicyCalculatorService getPricingPolicyCalculatorService(PricingPolicy pp) {
    	if (pp instanceof LinearPricingPolicy) {
    		return new LinearPricingPolicyCalculatorService();
    	} else if (pp instanceof FixedThenLinearPricingPolicy) {
    		return new FixedThenLinearPricingPolicyCalculatorService();
    	} 
        return null;
    }
}
