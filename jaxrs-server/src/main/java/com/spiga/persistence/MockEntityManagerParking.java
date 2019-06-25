package com.spiga.persistence;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Parking;

/**
 * Fake entity manager to handle the Parking persistence (in memory, as an example).
 * At term, a database access will replace this.
 * 
 * @author fspiga
 *
 */
public class MockEntityManagerParking {
	
	static Long lastParkingID = 0L;
	static List<Parking> parkings = new ArrayList<Parking>();
	
	private static MockEntityManagerParking instance;

    /** Don't let anyone else instantiate this class */
    private MockEntityManagerParking() {}

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized MockEntityManagerParking getInstance() {
        if(instance == null) {
            instance = new MockEntityManagerParking();
        }
        return instance;
    }
	
	public Parking addParking(Parking lot) {
		lot.setParkingId(generateNewParkingID());
		parkings.add(lot);
		return lot;
	}

	private Long generateNewParkingID() {
		return ++lastParkingID;
	}

	public Parking getParkingByID(Long lotId) {
		for (Parking l: parkings) {
			if (l.getParkingId().equals(lotId)) {
				return l;
			}
		}
		return null;
	}

	public List<Parking> getParkings() {
		return parkings;
	}

	public boolean deleteParking(Long lotId) {
		for (Parking l: parkings) {
			if (l.getParkingId().equals(lotId)) {
				return parkings.remove(l);
			}
		}
		return false;
	}

}
