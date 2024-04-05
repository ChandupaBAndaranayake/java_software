package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Model.MydbConnection;

public class login_Controller {
	private static Connection con = MydbConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	
	public Vector<String> getAdminpasswords() {
		Vector<String> password = new Vector<>();
		
		try {
			pst = con.prepareStatement("SELECT adminPassword FROM admins");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String u_name = rs.getString("adminPassword");
				password.add(u_name);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public Vector<String> getAdminUsername() {
		Vector<String> username = new Vector<>();
		
		try {
			pst = con.prepareStatement("SELECT adminUsername FROM admins");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String u_name = rs.getString("adminUsername");
				username.add(u_name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return username;
	}
	public Vector<String> getEmployeeUsername() {
		Vector<String> username = new Vector<>();
		
		try {
			pst = con.prepareStatement("SELECT username FROM employee");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String u_name = rs.getString("username");
				username.add(u_name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return username;
	}
	
	public Vector<String> getEmployeePassword() {
		Vector<String> password = new Vector<>();
		
		try {
			pst = con.prepareStatement("SELECT EMP_Password FROM employee");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String u_name = rs.getString("EMP_Password");
				password.add(u_name);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return password;
	}
	

}
