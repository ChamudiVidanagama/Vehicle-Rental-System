package com.iit.coursework;

import com.iit.coursework.controller.VehicleController;
import com.iit.coursework.model.Car;
import com.iit.coursework.model.Motorbike;
import com.iit.coursework.model.Vehicle;
import com.iit.coursework.service.RentalVehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.iit")
public class VehicleRentalSystemApplication {
	private Scanner managerInput = new Scanner(System.in);
	static String addnew;


	@Autowired
	RentalVehicleManager manager;


	private List <Vehicle> makeVehicleList=new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(VehicleRentalSystemApplication.class, args);
		addnew="yes";
		while(addnew.equals("yes")){		// loop in main menu if user wants to go to main menu
			new VehicleRentalSystemApplication().menu();
			Scanner managerInput = new Scanner(System.in);
			System.out.println("Do you want to go back to the menu (yes/no)?");
			addnew = managerInput.next();
		}

	}

	// main menu - manager can select functions
	public void menu() {
		System.out.println("Westminster vehicle Rental System");
		System.out.println("    1 : Add a vehicle");
		System.out.println("    2 : Delete a vehicle");
		System.out.println("    3 : Print vehicle list");
		System.out.println("    4 : generate report");
		System.out.println("    5 : Exit Application");
		System.out.print("Please enter your choice below : ");
		int userChoice = managerInput.nextInt();
		menuMethods(userChoice);

	}

	public void menuMethods(int userChoice) {
		switch(userChoice) {
			case 1:
				// can add vehicles
				addVehicleMethod();
				System.out.println("Click here http://localhost:9090/addVehicle to add vehicles");
				break;
			case 2:
				// can delete vehicle using plateNo
				deleteVehicleMethod();
				System.out.println("Click here http://localhost:9090/deleteVehicleFromId to delete vehicle");
				break;
			case 3:
				// can print all vehicle List
				System.out.println("Click here to http://localhost:9090/printList print list of vehicles");
				break;
			case 4:
				// can generate vehicle report
				System.out.println("Click here to http://localhost:9090/generateVehicleReport generate vehicle report in text file vehicleReport.txt");
				break;
			case 5:
				System.out.println("Thank you for using the application");
				System.exit(0);
				break;
			default:
				throw new IllegalStateException("Invalid user input: " + userChoice);
		}
	}

	// add vehicle method to add vehicles by getting user inputs from the manager
	public void addVehicleMethod(){
		do{
			String plateNo;
			while(true){
				try{
					System.out.print("Enter plate no  :   ");
					plateNo = managerInput.next();						// get plateNo from manager
					if (plateNo.length() > 5 && plateNo.length() < 8) {		// check if the plate number length is 6 or 7
						break;
					}else{
						System.out.print("Invalid plate no, ");			// if plate no length is not 6 or 7 display error message
					}
				}catch (InputMismatchException ex){			// input mismatch exception is handled
					ex.printStackTrace();
				}
			}

			String make;
			while(true){
				try{
					System.out.print("Enter vehicle make  :   ");		// get vehicle make from manager
					make = managerInput.next();
					if (make.length() < 20) {							// check if make lenght is less than 20
						break;
					}else{
						System.out.print("Invalid vehicle make, ");		// if make length is more than 20 display error message
					}
				}catch (InputMismatchException ex){
					ex.printStackTrace();
				}
			}

			String model;
			while(true){
				try{
					System.out.print("Enter vehicle model  :   ");		// get vehicle model from manager
					model = managerInput.next();
					if (model.length() < 20) {							// check if model lenght is less than 20
						break;
					}else{
						System.out.print("Invalid vehicle model, ");	// if model length is more than 20 display error message
					}
				}catch (InputMismatchException ex){
					ex.printStackTrace();
				}
			}

			BigDecimal rate;
			do {
				System.out.print("Enter vehicle rate  :   ");
				while (!managerInput.hasNextBigDecimal()) {			// get vehicle rate from manager and check whether it's bigDecimal type
					String invalidInput = managerInput.next();		// if not input converted to String and assigned to a variable
					System.out.printf("\"%s\" is not a valid input, Enter rate : ", invalidInput);	// display error message using string variable
				}
				rate = managerInput.nextBigDecimal();
			} while(rate.compareTo(BigDecimal.valueOf(0)) < 0);		// check if the value is less than 0 to continue the loop

			String transmission;
			while(true){
				try{
					System.out.print("Enter transmission (auto/manual)  :	");
					transmission = managerInput.next().toLowerCase();			// get vehicle transmission from manager and convert to lowercase
					if (transmission.equals("auto") || transmission.equals("manual")) {		// check if transmission equals to auto or manual
						break;
					}else{
						System.out.print("Invalid vehicle transmission, ");	// if not display error and continue loop
					}
				}catch (InputMismatchException ex){
					ex.printStackTrace();
				}
			}

			int engineCapacity;
			do {
				System.out.print("Enter engineCapacity  :   ");
				while (!managerInput.hasNextInt()) {				// get vehicle engineCapacity from manager and check whether it's int type
					String invalidInput = managerInput.next();		// if not input converted to String and assigned to a variable
					System.out.printf("\"%s\" is not a valid input, Enter engine capacity again : ", invalidInput); // display error message using string variable
				}
				engineCapacity = managerInput.nextInt();
			} while (engineCapacity < 0);			// check if the value is less than 0 to continue the loop

			int noOfPassengers;
			do {
				System.out.print("Enter no of passengers  :   ");
				while (!managerInput.hasNextInt()) {				// get vehicle no of passengers from manager and check whether it's int type
					String invalidInput = managerInput.next();		// if not input converted to String and assigned to a variable
					System.out.printf("\"%s\" is not a valid input, Enter no of passengers again : ", invalidInput); // display error message using string variable
				}
				noOfPassengers = managerInput.nextInt();
				System.out.println(noOfPassengers);
			} while (noOfPassengers < 0 || noOfPassengers > 6);		// check if the value is not between 0 and 6 to continue the loop

			String vehicleType;
			while(true){
				try{
					System.out.print("Enter the vehicle type (car/motorbike)? ");
					vehicleType = managerInput.next().toLowerCase();			// get vehicle vehicle type from manager and convert to lowercase
					if (vehicleType.equals("car") || vehicleType.equals("motorbike")) {		// check if vehicle type equals to car or motorbike
						break;
					}else{
						System.out.print("Invalid vehicle type, ");		// if not display error and continue loop
					}
				}catch (InputMismatchException ex){
					ex.printStackTrace();
				}
			}
			switch (vehicleType){
				case "car":
					String typeOfCar;
					while(true){
						try{
							System.out.print("Enter type of car (economy/luxury) :   ");
							typeOfCar = managerInput.next().toLowerCase();		// get car type of car from manager and convert to lowercase
							if (typeOfCar.equals("economy") || typeOfCar.equals("luxury")) {	// check if type of car equals to economy or luxury
								break;
							}else{
								System.out.print("Invalid vehicle type, ");		// if not display error and continue loop
							}
						}catch (InputMismatchException ex){
							ex.printStackTrace();
						}
					}


					System.out.print("Is vehicle air conditioned (true/false) :   ");
					while (!managerInput.hasNextBoolean()) {			// get car air conditioned? from manager and check whether it's boolean type
						String invalidInput = managerInput.next();		// if not air condition? input converted to String and assigned to a variable
						System.out.printf("\"%s\" is not a valid input, Is vehicle air conditioned (true/false) : ", invalidInput); // display error message using string variable
					}
					boolean isAirConditioned = managerInput.nextBoolean();
					// pass car object to the vehicle list
					VehicleController.vehicleList.add(new Car(plateNo,make,model,rate,transmission,engineCapacity,noOfPassengers,vehicleType,typeOfCar,isAirConditioned));
					break;
				case "motorbike":
					String bikeType;
					while(true){
						try{
							System.out.print("Enter type of bike (standard/sports) :   ");
							bikeType = managerInput.next().toLowerCase();				// get motorbike bikeType from manager and convert to lowercase
							if (bikeType.equals("standard") || bikeType.equals("sports")) {		// check if bike type equals to standard or sports
								break;
							}else{
								System.out.print("Invalid vehicle type, ");			// if not display error and continue loop
							}
						}catch (InputMismatchException ex){
							ex.printStackTrace();
						}
					}
					boolean isClutchBike;
					System.out.print("Is clutch bike (true/false) :   ");
					while (!managerInput.hasNextBoolean()) {			// get motorbike clutch bike? from manager and check whether it's boolean type
						String invalidInput = managerInput.next();		// if not clutch bike? input converted to String and assigned to a variable
						System.out.printf("\"%s\" is not a valid input, Is clutch bike (true/false) : ", invalidInput);		// display error message using string variable
					}
					isClutchBike = managerInput.nextBoolean();
					// pass motorbike object to the vehicle list
					VehicleController.vehicleList.add(new Motorbike(plateNo,make,model,rate,transmission,engineCapacity,noOfPassengers,vehicleType,bikeType,isClutchBike));
					break;
			}
			System.out.print("Do you want to add new vehicle(yes/no)?");
			addnew = managerInput.next().toLowerCase();
		}while(addnew.equals("yes"));

	}

	public void deleteVehicleMethod(){
		System.out.print("Enter plate no to delete? ");
		String plateNo = managerInput.next();
		VehicleController.plateNo = plateNo;
	}


}
