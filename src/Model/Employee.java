

package Model;

import java.util.Map;


public abstract class Employee   {
    private String employeeId;
    private String name;
   
	private String role;
    private double salary;
    private String username;
    private String password;
 

    public Employee() {
    	
    }
    
    public Employee(String employeeId, String name, String role, double salary,String username, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.username = username;
        this.setPassword(password);
    }

    public void updateRole(String Role) {
        this.role = Role;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }
    
    // Getters and setters for the attributes
    
    public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }
        
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	   
    //creating pasword hashu mapppo
    public abstract Map<String, String> passwordHashmap();
    public abstract void updateSalary(double salary, String empid);
    public abstract void updateRole(String role , String empid);
}





