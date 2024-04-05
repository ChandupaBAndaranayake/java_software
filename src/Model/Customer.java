package Model;

public class Customer {
    // Customer attributes
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String NIC;
    private String LIC;
    
    public Customer() {
    	System.out.println("Customer");
    }
    
    public Customer(String customerID){
    	this.customerId = customerID;
    }
   
    // Constructor
    public Customer(String customerId, String firstName, String lastName, String phoneNumber, String email, String NIC, String LIC) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;  
        this.NIC = NIC;
        this.LIC = LIC;
    }
    
    // Getter and setter methods for class fields
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public String getLIC() {
		return LIC;
	}

	public void setLIC(String lIC) {
		LIC = lIC;
	}
	
}
