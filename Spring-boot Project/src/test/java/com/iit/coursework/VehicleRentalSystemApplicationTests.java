package com.iit.coursework;

import com.iit.coursework.model.Vehicle;
import com.iit.coursework.service.RentalVehicleManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class VehicleRentalSystemApplicationTests {
@Autowired
private RentalVehicleManager rentalVehicleManager;

List<Vehicle> vehicleList = new ArrayList<>();

	@Test
	void verifyTestingByGivenId() {       // test the getVehicle method is correct
		String testName = rentalVehicleManager.getVehicle("KV1234");
		Assert.assertEquals("Toyota Prius", testName);
	}

	@Test
	void checkSlotAvailability(){         // test slot availability using error message get from 50 slots
		for (int i=0; i <= 50; i++){
			Vehicle vehicle = new Vehicle("CAA0897","Toyota","Axio",BigDecimal.valueOf(50000),"auto",1500,4,"car");
			vehicle.setNoOfPassengers(4);
			vehicle.setVehicleType("car");
			vehicleList.add(vehicle);
		}
		String testMessage = rentalVehicleManager.addVehicleList(vehicleList);
		Assert.assertEquals("NO SLOTS AVAILABLE",testMessage);
	}

	@Test
	void testDeleteVehicle(){            // test delete method when input plateNo
		String testMessage = rentalVehicleManager.deleteVehicle("CAH0898");
		Assert.assertEquals("CAH0898 successfully deleted",testMessage);
	}
}



