package com.spiga.api.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import io.swagger.client.ApiException;
import io.swagger.client.api.LotApi;
import io.swagger.client.api.ParkingApi;
import io.swagger.client.model.Bill;
import io.swagger.client.model.Car;
import io.swagger.client.model.Lot;
import io.swagger.client.model.Parking;
import io.swagger.client.model.Car.CarTypeEnum;
import io.swagger.client.model.Lot.LotStatusEnum;

public class TestParkingApi {

	@Test
	public void testInventory() throws Exception {
		ParkingApi parkingApiInstance = new ParkingApi();
		List<Lot> lots = parkingApiInstance.getLots(null, null);
		System.out.println("********************************");
		System.out.println("** Inventory lots             **");
		System.out.println("********************************");
		System.out.println(lots);
		System.out.println("");
		assertNotNull(lots);
		assertEquals(12, lots.size());
	}
	
	@Test
	public void testParking() throws Exception {
	   	
    	// A new car is incoming
    	Car car1 = createNewCar(CarTypeEnum.GASOLINE, "AA123BB");
    	ParkingClient parking1 = new ParkingClient(car1);
    	
    	// Starting the car parking operation
    	parking1.startParking();
    	assertEquals((Long)1L, (Long) parking1.getLot().getLotId());
    	
    	// Waiting for the car leaving the lot    	
    	Thread.sleep(5000);
    	
    	// A 2nd car is incoming, same type GASOLINE:
    	// I expect the slot #1 BUSY, so taking another one.
    	Car car2 = createNewCar(CarTypeEnum.GASOLINE, "DC254RT");
    	ParkingClient parking2 = new ParkingClient(car2);
    	parking2.startParking();
    	assertEquals((Long)2L, (Long) parking2.getLot().getLotId());
    	
    	// Computing the bill
    	parking1.billParking();
    	
    	// Leaving the parking
    	parking1.endParking();  
    	
    	// A 3rd car is incoming, same type GASOLINE:
    	// I expect the slot #1 AVAILABLE again, so taking that one.
    	Car car3 = createNewCar(CarTypeEnum.GASOLINE, "AD264FG");
    	ParkingClient parking3 = new ParkingClient(car3);
    	parking3.startParking();
    	assertEquals((Long)1L, (Long) parking3.getLot().getLotId());

    	// Computing the bill
    	parking2.billParking();
    	
    	// Leaving the parking
    	parking2.endParking();  

    	// Computing the bill
    	parking3.billParking();
    	
    	// Leaving the parking
    	parking3.endParking();  
	}
	
	@Test
	public void testError204() throws Exception {
		ParkingApi parkingApiInstance = new ParkingApi();
		List<Lot> lots = parkingApiInstance.getLots(LotStatusEnum.BUSY.toString(), null);
		assertNull(lots);
	}	

	private Car createNewCar(CarTypeEnum type, String numberplate) {
    	Car car = new Car();
    	car.setCarType(type);
    	car.setNumberplate(numberplate);
    	System.out.println("Coming car:\n" + car);
		return car;
	}
	
}
