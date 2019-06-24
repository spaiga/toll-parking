package com.spiga.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import java.util.ArrayList;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.math.BigDecimal;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.spiga.api.factories.PricingPolicyCalculatorServiceFactory;
import com.spiga.api.pricing.PricingPolicyCalculatorService;
import com.spiga.persistence.MockEntityManagerLot;
import com.spiga.persistence.MockEntityManagerParking;
import com.spiga.persistence.MockEntityManagerPricingPolicies;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-22T09:26:22.482Z")
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
