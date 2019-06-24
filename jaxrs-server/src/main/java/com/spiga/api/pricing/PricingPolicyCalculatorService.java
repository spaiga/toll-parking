package com.spiga.api.pricing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Bill;
import io.swagger.model.BillMonetaryAmount;
import io.swagger.model.PricingPolicy;

public abstract class PricingPolicyCalculatorService {

	protected abstract Long computeAmount(Long timeSpentInSeconds, PricingPolicy pp);
	
	public Bill computeBill(Long timeSpentInSeconds, PricingPolicy pp) {
		Long amountLong = this.computeAmount(timeSpentInSeconds, pp);
		
		Bill bill = new Bill();
		bill.setTimeSpentInHours(timeSpentInSeconds);
		List<BillMonetaryAmount> monetaryAmount = new ArrayList<>();
		BillMonetaryAmount bmm = new BillMonetaryAmount();
		bmm.setCurrency("EUR");
		bmm.setAmount(BigDecimal.valueOf(amountLong));
		monetaryAmount.add(bmm);
		bill.setMonetaryAmount(monetaryAmount);
		return bill;
	}

}
