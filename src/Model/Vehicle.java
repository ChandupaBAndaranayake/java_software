package Model;

import java.util.Map;

public abstract class Vehicle {
	
	private String vehicleID;
	private String vehicleType;
	private String model;
	private double dailyRate;
	private String fuelType;
	private String available;
	
	public Vehicle() {
		System.out.println("vehicle");
	}
	public Vehicle(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public Vehicle(String vehicleID, String vehicleType,String model,double dailyRate,String fuelType,String available){
		this.setVehicleID(vehicleID);
		this.setVehicleType(vehicleType);
		this.setModel(model);
		this.setDailyRate(dailyRate);
		this.setFuelType(fuelType);
		this.setAvailable(available);
	}
	
	public abstract void updateavailabilty(String vehicleID, String call);
	public abstract Map<String,String> getVehicle_available();
	
	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
