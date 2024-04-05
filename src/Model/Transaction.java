package Model;

import java.util.Date;

public class Transaction {
    private String transactionID;
    private String customerID;
    private String vehicleID;//rented vehicle
    private String rentalStartDate;
    private String rentalEndDate;
    private double totalAmount;
    private double advancePaid;
    private double dueAmount;
    private String returnStatus;
    
    public Transaction() {
    	System.out.println("Transaction");
    }
    
    public Transaction(String transactionId, String customerID, String vehicleID, String rentalStartDate,String rentalEndDate,double totalAmount,double advancePaid,double dueAmount,String returnStatus) {
        this.setTransactionId(transactionId);
        this.setCustomerID(customerID);
        this.setVehicleID(vehicleID);
        this.setRentalStartDate(rentalStartDate);
        this.setRentalEndDate(rentalEndDate);
        this.setTotalAmount(totalAmount);
        this.setAdvancePaid(advancePaid);
        this.setDueAmount(dueAmount);
        this.setReturnStatus(returnStatus); // Set to true when the vehicle is returned
    }
    public Transaction(String transactionId, String rentalStartDate,String rentalEndDate,double totalAmount,double advancePaid,double dueAmount,String returnStatus ) {
    	this.setTransactionId(transactionId);
    	 this.setRentalStartDate(rentalStartDate);
         this.setRentalEndDate(rentalEndDate);
         this.setTotalAmount(totalAmount);
         this.setAdvancePaid(advancePaid);
         this.setDueAmount(dueAmount);
         this.setReturnStatus(returnStatus);
    }

	public String getTransactionId() {
		return transactionID;
	}

	public void setTransactionId(String transactionId) {
		this.transactionID = transactionId;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getRentalStartDate() {
		return rentalStartDate;
	}

	public void setRentalStartDate(String startDate) {
		this.rentalStartDate = startDate;
	}

	public String getRentalEndDate() {
		return rentalEndDate;
	}

	public void setRentalEndDate(String rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount2) {
		this.totalAmount = totalAmount2;
	}

	public double getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}


}


