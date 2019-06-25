package com.spiga.api.impl;

import javax.validation.constraints.Min;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.spiga.api.factories.PricingPolicyCalculatorServiceFactory;
import com.spiga.api.pricing.PricingPolicyCalculatorService;
import com.spiga.persistence.MockEntityManagerLot;
import com.spiga.persistence.MockEntityManagerParking;
import com.spiga.persistence.MockEntityManagerPricingPolicies;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.ParkingsApiService;
import io.swagger.model.Bill;
import io.swagger.model.Lot;
import io.swagger.model.Parking;
import io.swagger.model.PricingPolicy;

/**
 * Implementations of the API associated to the Parking resource.
 * @author fspiga
 *
 */
public class MockParkingsApiServiceImpl extends ParkingsApiService {
    @Override
    public Response addParking(Parking body, SecurityContext securityContext) throws NotFoundException {
        Parking p = MockEntityManagerParking.getInstance().addParking(body);
        return Response.ok().entity(p).build();
    }
    @Override
    public Response getParkingBill( @Min(1L)Long parkingId, SecurityContext securityContext) throws NotFoundException {
    	// Get parking
    	Parking p = MockEntityManagerParking.getInstance().getParkingByID(parkingId);
    	p.setEndDate(System.currentTimeMillis()); // useful only in case of persistence as historic
    	// Get lotID
    	Lot lot = MockEntityManagerLot.getInstance().getLotByID(p.getLotId());
    	// Get Pricing Policy
    	Long pricingPolicyID = lot.getPricingPolicyId();
    	PricingPolicy pp = MockEntityManagerPricingPolicies.getInstance().getPricingPolicyByID(pricingPolicyID);
    	// Get calculator service
    	PricingPolicyCalculatorService calculator = PricingPolicyCalculatorServiceFactory.getPricingPolicyCalculatorService(pp);
    	// Calculating Bill
		Long timeSpentInSeconds = (p.getEndDate() - p.getStartDate()) / 1000;
		Bill bill = calculator.computeBill(timeSpentInSeconds, pp);
		
    	//Returning Bill
        return Response.ok().entity(bill).build();
    }
    @Override
    public Response deleteParking( @Min(1L)Long parkingId, SecurityContext securityContext) throws NotFoundException {
        MockEntityManagerParking.getInstance().deleteParking(parkingId);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
	@Override
	public Response getParkingByID(Long parkingId, SecurityContext securityContext) throws NotFoundException {
		Parking p = MockEntityManagerParking.getInstance().getParkingByID(parkingId);
		return Response.ok().entity(p).build();
	}
}
