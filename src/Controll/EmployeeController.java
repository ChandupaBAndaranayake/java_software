package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

import Model.Employee;
import Model.Admin;
import Model.Database;

public class EmployeeController extends Employee implements Controller{
	
	
	PreparedStatement P1;
	static Database db= new Database();
	private static Connection con = db.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private String employeeID;//employee id is global variable
	
	public EmployeeController() {
		super();
	}
	


	//call any employeeID
	public EmployeeController(String employeeID){
		this.employeeID=employeeID;
		
	}
	
	 
	
	
	@Override
	public void Create() {
		// TODO Auto-generated method stub
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_rental_system","root","");//database connection
			
			 
			
			 
			 P1 = db.getConnection().prepareStatement("insert into employee(employeeID,empName,empRole,salary,username,EMP_Password)values(?,?,?,?,?,?)");
			 P1.setString(1,this.getEmployeeId());
			 P1.setString(2,this.getName());
			 P1.setString(3,this.getRole());
			 P1.setDouble(4,this.getSalary());
			 P1.setString(5,this.getUsername());
			 P1.setString(6,this.getPassword());
			  
			 P1.executeUpdate();
			 
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
	
	}
	
	@Override
	public  Vector<Vector<Object>> Read() {
		Vector<Vector<Object>> data = new Vector<>();
		try{
			
			pst = con.prepareStatement("SELECT * FROM employee WHERE employeeID = ?");
			String employeeID = this.employeeID;
			pst.setString(1, employeeID);
			
			rs = pst.executeQuery();
			
			//get column information
			ResultSetMetaData rd = rs.getMetaData();
			//System.out.println(rd);
			int columncount = rd.getColumnCount();
			
			while(rs.next()) {
				Vector<Object> rowData = new Vector<>();
				
				for(int i = 1; i <= columncount;i++) {
					rowData.add(rs.getString(i));
				}
				/*can take anything from this vector*/
				data.add(rowData); // Add rowData to the data vector
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}// TODO Auto-generated method stub
		return data;
		
	}
	

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//database connection
		 
		 try {
			P1 = db.getConnection().prepareStatement("update employee set empName =?, empRole=?,salary=?, username=?, EMP_Password=? where employeeID=?");
			
			 
			 P1.setString(1,this.getName());
			 P1.setString(2,this.getRole());
			 P1.setDouble(3,this.getSalary());
			 P1.setString(4,this.getUsername());
			 P1.setString(5,this.getPassword());
			 P1.setString(6,this.getEmployeeId());
			 P1.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		 
		 
		
		
		
	}


	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		
		try {
			P1 = db.getConnection().prepareStatement("Delete from employee where employeeID = ?");
			
			P1.setString(1,this.employeeID);
			P1.executeUpdate();
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, String> passwordHashmap() {
		
		Map<String, String> passwordHashmap = new ConcurrentHashMap<String,String>();
		
		
		try {
			P1 = con.prepareStatement("SELECT username,EMP_Password FROM employee");
			rs = P1.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("EMP_Password");
				
				
				passwordHashmap.put(username, password);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void updateSalary(double salary, String empid) {
		try {
			P1 = con.prepareStatement("update employee set salary = ? where employeeID=?");
			 P1.setDouble(1,salary);
			 P1.setString(2,empid);
			 
			 P1.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateRole(String role, String empid) {
		try {
			P1 = con.prepareStatement("update employee set empRole = ? where employeeID=?");
			 P1.setString(1,role);
			 P1.setString(2,empid);
			 
			 P1.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
