package com.spiga.api.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.spiga.persistence.MockEntityManagerLot;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.LotsApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Lot;

/**
 * Implementations of the API associated to the Lot resource.
 * @author fspiga
 *
 */
public class MockLotsApiServiceImpl extends LotsApiService {

    @Override
    public Response addLot(Lot body, SecurityContext securityContext) throws NotFoundException {
        Lot addedLot = MockEntityManagerLot.getInstance().addLot(body); 
        System.out.println("Added lot with ID #" + addedLot.getLotId());  
        return Response.ok().entity(addedLot).build();
    }
    @Override
    public Response deleteLot(Long lotId, SecurityContext securityContext) throws NotFoundException {
        boolean deleted = MockEntityManagerLot.getInstance().deleteLot(lotId);
        if (deleted) {
        	System.out.println("Deleted lot #" + lotId); 
        	return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Lot #" + lotId + " deleted!")).build();
        }
        else {
        	System.out.println("Unable to delete lot #" + lotId); 
        	return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Lot #" + lotId + " NOT deleted!")).build();
        }
    }
    @Override
    public Response getLotByID(Long lotId, SecurityContext securityContext) throws NotFoundException {
        Lot lot = MockEntityManagerLot.getInstance().getLotByID(lotId);
        System.out.println("Returning lot #" + lot.getLotId()); 
        return Response.ok().entity(lot).build();
    }
    @Override
    public Response getLots(String status, String carType, SecurityContext securityContext) throws NotFoundException {
        List<Lot> lots = MockEntityManagerLot.getInstance().getLots(status, carType);
        if (lots == null || lots.isEmpty()) {
        	return Response.noContent().build();
        }
        return Response.ok().entity(lots).build();
    }
	@Override
	public Response updateLotStatus(Lot body, SecurityContext securityContext) throws NotFoundException {
        Lot lotUpdated = MockEntityManagerLot.getInstance().updateLotStatus(body);  
        return Response.ok().entity(lotUpdated).build();
	}

}
