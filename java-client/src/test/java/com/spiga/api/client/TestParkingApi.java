package com.spiga.api.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.swagger.client.ApiException;
import io.swagger.client.api.LotApi;
import io.swagger.client.api.ParkingApi;
import io.swagger.client.api.PricingPolicyApi;
import io.swagger.client.model.Bill;
import io.swagger.client.model.Car;
import io.swagger.client.model.Car.CarTypeEnum;
import io.swagger.client.model.FixedThenLinearPricingPolicy;
import io.swagger.client.model.LinearPricingPolicy;
import io.swagger.client.model.Lot;
import io.swagger.client.model.Lot.LotStatusEnum;
import io.swagger.client.model.PricingPolicy;

/**
 * Unit Test class for the Toll Parking API
 * @author fspiga
 *
 */
public class TestParkingApi {
	
	private static Long pricingPolicy1_cost;
	private static Long pricingPolicy2_cost;
	private static Long pricingPolicy2_fixed;
	
	@Before
	public void getExpectePricingPolicies() throws ApiException {
		LotApi lotApiInstance = new LotApi();
		PricingPolicyApi pricingPolicyApiInstance = new PricingPolicyApi();
		
		// extracting parameters from Pricing Policy associated to the lot #1
		Long ppId1 = lotApiInstance.getLotByID(1L).getPricingPolicyId();
		assertNotNull(ppId1);
		PricingPolicy pp1 = pricingPolicyApiInstance.getPricingPolicyById(ppId1);
		assertNotNull(pp1);
		assertEquals(LinearPricingPolicy.class.getSimpleName(), pp1.getPricingPolicyType());
		pricingPolicy1_cost = ((LinearPricingPolicy)pp1).getHourPrice().longValue();
    
		// extracting parameters from Pricing Policy associated to the lot #2
		Long ppId2 = lotApiInstance.getLotByID(2L).getPricingPolicyId();
		assertNotNull(ppId2);
		PricingPolicy pp2 = pricingPolicyApiInstance.getPricingPolicyById(ppId2);
		assertNotNull(pp2);
		assertEquals(FixedThenLinearPricingPolicy.class.getSimpleName(), pp2.getPricingPolicyType());
		pricingPolicy2_fixed = ((FixedThenLinearPricingPolicy)pp2).getFixedAmount().longValue();
		pricingPolicy2_cost = ((FixedThenLinearPricingPolicy)pp2).getHourPrice().longValue();
    }
	
	/**
	 * Testing the getLots method without any filter,
	 * supposed to return 12 lots as prefilled for example.
	 * @throws Exception
	 */
	@Test
	public void testInventory() throws Exception {
		ParkingApi parkingApiInstance = new ParkingApi();
		List<Lot> lots = parkingApiInstance.getLots(null, null);
		System.out.println("********************************");
		System.out.println("** Inventory lots             **");
		System.out.println("********************************");
		System.out.println(lots);
		assertNotNull(lots);
		assertEquals(12, lots.size());
	}
	
	/**
	 * Testing 3 parking operations interacting each other.
	 * 3 gasoline cars are coming for the toll parking:
	 * - the car #1 will occupy the lot #1
	 * - the car #2 will occupy the lot #2, being the lot #1 busy
	 * - the car #3 will occupy the lot #1, being the lot #1 available again
	 * 
	 * Moreover, the lot #1 applies a "linear" pricing policy (3 EUR/hour),
	 * whereas the lot #2 has also a fixed amount (5 EUR + 2 EUR/hour).
	 * 
	 * @throws Exception
	 */
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
    	Bill bill1 = parking1.billParking();
    	assertNotNull(bill1);
    	Long expectedAmount = (bill1.getTimeSpentInHours() * pricingPolicy1_cost);
    	assertEquals(expectedAmount, (Long)bill1.getMonetaryAmount().get(0).getAmount().longValue());
    	
    	// Leaving the parking
    	parking1.endParking();  
    	
    	// A 3rd car is incoming, same type GASOLINE:
    	// I expect the slot #1 AVAILABLE again, so taking that one.
    	Car car3 = createNewCar(CarTypeEnum.GASOLINE, "AD264FG");
    	ParkingClient parking3 = new ParkingClient(car3);
    	parking3.startParking();
    	assertEquals((Long)1L, (Long) parking3.getLot().getLotId());

    	// Computing the bill
    	Bill bill2 = parking2.billParking();    	
    	assertNotNull(bill2);
    	expectedAmount = pricingPolicy2_fixed + (bill2.getTimeSpentInHours() * pricingPolicy2_cost);
    	assertEquals(expectedAmount, (Long)bill2.getMonetaryAmount().get(0).getAmount().longValue());
    	
    	
    	// Leaving the parking
    	parking2.endParking();  

    	// Computing the bill
    	Bill bill3 = parking3.billParking();
    	assertNotNull(bill3);
    	expectedAmount = (bill3.getTimeSpentInHours() * pricingPolicy1_cost);
    	assertEquals(expectedAmount, (Long)bill3.getMonetaryAmount().get(0).getAmount().longValue());
    	
    	
    	// Leaving the parking
    	parking3.endParking();  
	}
	
	/**
	 * Testing case where no lots are returned
	 * @throws Exception
	 */
	@Test
	public void testError204() throws Exception {
		ParkingApi parkingApiInstance = new ParkingApi();
		List<Lot> lots = parkingApiInstance.getLots(LotStatusEnum.BUSY.toString(), null);
		assertNull(lots);
	}	

	/**
	 * Creating a new car to test
	 * @param type
	 * @param numberplate
	 * @return
	 */
	private Car createNewCar(CarTypeEnum type, String numberplate) {
    	Car car = new Car();
    	car.setCarType(type);
    	car.setNumberplate(numberplate);
    	System.out.println("Coming car:\n" + car);
		return car;
	}
	
}
