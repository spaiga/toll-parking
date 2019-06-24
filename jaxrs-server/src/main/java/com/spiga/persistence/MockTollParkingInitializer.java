package com.spiga.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Lot.CarTypeEnum;
import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.LinearPricingPolicy;
import io.swagger.model.Lot;
import io.swagger.model.Lot.LotStatusEnum;
import io.swagger.model.LotCoordinates;
import io.swagger.model.PricingPolicy;

public class MockTollParkingInitializer {
	
	private static MockTollParkingInitializer instance;

    /** Don't let anyone else instantiate this class */
    private MockTollParkingInitializer() {}

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized MockTollParkingInitializer getInstance() {
        if(instance == null) {
            instance = new MockTollParkingInitializer();
        }
        return instance;
    }
    
	public void initParkingConfiguration() {
		System.out.println("********************************");
		System.out.println("** Initializing Configuration **");
		System.out.println("********************************");
		

		System.out.print("Creating pricing policies ... ");
		PricingPolicy lpp = addLinearPricingPolicy();
		PricingPolicy flpp = addFixedThenLinearPricingPolicy();
		System.out.println("OK!");


		System.out.print("Creating lots ... ");
        addLot(CarTypeEnum.GASOLINE, 		"1", "A", "101", lpp);
        addLot(CarTypeEnum.GASOLINE, 		"1", "A", "102", flpp);
        addLot(CarTypeEnum.GASOLINE, 		"1", "B", "103", flpp);
        addLot(CarTypeEnum.ELECTRIC20KW, 	"1", "B", "104", lpp);
        addLot(CarTypeEnum.GASOLINE, 		"2", "C", "201", lpp);
        addLot(CarTypeEnum.GASOLINE, 		"2", "C", "202", flpp);
        addLot(CarTypeEnum.ELECTRIC20KW, 	"2", "D", "203", lpp);
        addLot(CarTypeEnum.ELECTRIC50KW, 	"2", "D", "204", lpp);
        addLot(CarTypeEnum.GASOLINE, 		"3", "E", "301", flpp);
        addLot(CarTypeEnum.ELECTRIC20KW, 	"3", "E", "302", flpp);
        addLot(CarTypeEnum.ELECTRIC50KW, 	"3", "F", "303", flpp);
        addLot(CarTypeEnum.ELECTRIC50KW, 	"3", "F", "304", lpp);
		System.out.println("OK!");

	}
	
	private Lot addLot(CarTypeEnum type, String floor, String sector, String placeNumber, PricingPolicy lpp) {
        Lot lot = new Lot(); 
        lot.setLotStatus(LotStatusEnum.AVAILABLE);
        lot.setCarType(type);
        lot.setPricingPolicyId(lpp.getPricingPolicyId());
        LotCoordinates coordinates = new LotCoordinates();
        coordinates.setFloor(floor);
        coordinates.setSector(sector);
        coordinates.setPlaceNumber(placeNumber);
		lot.setCoordinates(coordinates);
		Lot lotResult = MockEntityManagerLot.getInstance().addLot(lot);
		return lotResult;
	}

	private PricingPolicy addLinearPricingPolicy() {
        LinearPricingPolicy pp = new LinearPricingPolicy();
        pp.setPricingPolicyType(LinearPricingPolicy.class.getSimpleName());
        pp.setHourPrice(BigDecimal.valueOf(3));
        PricingPolicy ppResult = MockEntityManagerPricingPolicies.getInstance().addPricingPolicy(pp);
        return ppResult;
	}

	private PricingPolicy addFixedThenLinearPricingPolicy() {
        FixedThenLinearPricingPolicy pp = new FixedThenLinearPricingPolicy();
        pp.setPricingPolicyType(FixedThenLinearPricingPolicy.class.getSimpleName());
        pp.setHourPrice(BigDecimal.valueOf(2));
        pp.setFixedAmount(BigDecimal.valueOf(5));
        PricingPolicy ppResult = MockEntityManagerPricingPolicies.getInstance().addPricingPolicy(pp);
        return ppResult;
	}
}
