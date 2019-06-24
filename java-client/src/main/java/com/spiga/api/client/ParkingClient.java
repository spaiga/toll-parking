package com.spiga.api.client;

import java.util.List;

import io.swagger.client.ApiException;
import io.swagger.client.api.LotApi;
import io.swagger.client.api.ParkingApi;
import io.swagger.client.model.Bill;
import io.swagger.client.model.Car;
import io.swagger.client.model.Lot;
import io.swagger.client.model.Lot.LotStatusEnum;
import io.swagger.client.model.Parking;


/**
 * Example of a client using the Toll Parking API
 * 
 * @author fspiga
 *
 */
public class ParkingClient {
        
	ParkingApi parkingApiInstance = new ParkingApi();
	
	private Car car;
	private Lot lot;
	private Parking park;
	
	public ParkingClient(Car c) {
		this.car = c;
	}

	public void startParking() throws Exception {
    	this.lot = this.findAvailableLotByCarType(car.getCarType().toString());
    	if (lot == null) {
    		// TO DO : implement 'refuse' response from API
    		throw new Exception("No lots available!");
    	}
 
    	park = new Parking();
        park.setLotId(this.lot.getLotId());
        park.setCar(this.car);
        park.setStartDate(System.currentTimeMillis());
			
        // saving the parking via API
        Parking pResult = parkingApiInstance.addParking(park);
        this.park = pResult;
        System.out.println("Created Parking:\n" + pResult);
        
        // marking the lot as BUSY via API
		Lot lotUpdated = setLotStatus(LotStatusEnum.BUSY);
        System.out.println("Lot updated:\n" + lotUpdated);
	}

	public Lot findAvailableLotByCarType(String carType) throws Exception {
		// Find all the available lots by car type
		List<Lot> result = parkingApiInstance.getLots(
				LotStatusEnum.AVAILABLE.toString(),
				carType);
		System.out.println("Available lots:\n" + result);
		
		if (result == null || result.isEmpty()) {
    		// TO DO : implement 'refuse' response from API
    		throw new Exception("No lots available!");
    	}
		
		// Returning the 1st one, assuming it is the closer
		this.lot = result.get(0);
		System.out.println("Selected lot:\n" + this.lot);
		return this.lot;
	}
	
	public Bill billParking() throws ApiException {
		// Computing bill for the parking
		Bill bill = parkingApiInstance.getParkingBill(park.getParkingId());
        System.out.println(bill);
        return bill;
	}

	public void endParking() throws ApiException {  
		// Leaving parking, deleting the resource
		parkingApiInstance.deleteParking(park.getParkingId());
		
		// Marking the Lot to AVAILABLE
		Lot lotUpdated = setLotStatus(LotStatusEnum.AVAILABLE);
        System.out.println("Lot updated:\n" + lotUpdated);
	}

	private Lot setLotStatus(LotStatusEnum value) throws ApiException {
		// Updating the status of a Lot
		LotApi lotApiInstance = new LotApi();
		this.lot.setLotStatus(value);
        return lotApiInstance.updateLotStatus(lot);
	}

	protected Lot getLot() {
		return this.lot;
	}

}
