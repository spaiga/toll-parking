package com.spiga.api.pricing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Bill;
import io.swagger.model.BillMonetaryAmount;
import io.swagger.model.PricingPolicy;

/**
 * 
 * PricingPolicyCalculatorService is in charge of implementing the logic to calculate the amount to pay.
 * 
 * A shared part allows to create the Bill format,
 * whereas the computation logic is delegated to the specialized classes.
 * 
 * @author fspiga
 *
 */
public abstract class PricingPolicyCalculatorService {

	/**
	 * It implements the computation logic, to be defined in each specialized class.
	 * @param timeSpentInSeconds
	 * @param pp
	 * @return
	 */
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
