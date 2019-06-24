package com.spiga.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.swagger.model.Lot;

public class MockEntityManagerLot {
	
	static Long lastLotID = 0L;
	static List<Lot> lots = new ArrayList<Lot>();
	
	private static MockEntityManagerLot instance;

    /** Don't let anyone else instantiate this class */
    private MockEntityManagerLot() {}

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized MockEntityManagerLot getInstance() {
        if(instance == null) {
            instance = new MockEntityManagerLot();
        }
        return instance;
    }
	
	public Lot addLot(Lot lot) {
		lot.setLotId(generateNewLotID());
		lots.add(lot);
		return lot;
	}

	private Long generateNewLotID() {
		return ++lastLotID;
	}

	public Lot getLotByID(Long lotId) {
		for (Lot l: lots) {
			if (l.getLotId().equals(lotId)) {
				return l;
			}
		}
		return null;
	}

	
	/**
	 * status and carType are optional: if they are empty, all the lots are returned.
	 * @param status
	 * @param carType
	 * @return
	 */
	public List<Lot> getLots(String status, String carType) {
		List<Lot> filtered = new ArrayList<>();
		for (Lot l: lots) {
			if (StringUtils.isEmpty(status) || (status.equals(l.getLotStatus().toString()))) {
				if (StringUtils.isEmpty(carType) || (carType.equals(l.getCarType().toString()))) {
					filtered.add(l);
				}
			}
		}
		return filtered;
	}

	public boolean deleteLot(Long lotId) {
		for (Lot l: lots) {
			if (l.getLotId().equals(lotId)) {
				return lots.remove(l);
			}
		}
		return false;
	}

	public Lot updateLotStatus(Lot body) {
		Lot lot = getLotByID(body.getLotId());
		lot.setLotStatus(body.getLotStatus());	
		return lot;
	}

}
