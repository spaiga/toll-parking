package com.spiga.persistence;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.PricingPolicy;

/**
 * Fake entity manager to handle the PricingPolicy persistence (in memory, as an example).
 * At term, a database access will replace this.
 * 
 * @author fspiga
 *
 */
public class MockEntityManagerPricingPolicies {
	
	static Long lastPricingPolicyID = 0L;
	static List<PricingPolicy> pricingPolicies = new ArrayList<PricingPolicy>();
	
	private static MockEntityManagerPricingPolicies instance;

    /** Don't let anyone else instantiate this class */
    private MockEntityManagerPricingPolicies() {}

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized MockEntityManagerPricingPolicies getInstance() {
        if(instance == null) {
            instance = new MockEntityManagerPricingPolicies();
        }
        return instance;
    }
	
	public PricingPolicy addPricingPolicy(PricingPolicy pp) {
		pp.setPricingPolicyId(generateNewPricingPolicyID());
		pricingPolicies.add(pp);
		return pp;
	}

	private Long generateNewPricingPolicyID() {
		return ++lastPricingPolicyID;
	}

	public PricingPolicy getPricingPolicyByID(Long id) {
		for (PricingPolicy pp: pricingPolicies) {
			if (pp.getPricingPolicyId().equals(id)) {
				return pp;
			}
		}
		return null;
	}

	public List<PricingPolicy> getPricingPolicys() {
		return pricingPolicies;
	}

	public boolean deletePricingPolicy(Long lotId) {
		for (PricingPolicy l: pricingPolicies) {
			if (l.getPricingPolicyId().equals(lotId)) {
				return pricingPolicies.remove(l);
			}
		}
		return false;
	}

	public void initParkingConfiguration() {
		//TO DO
	}

}
