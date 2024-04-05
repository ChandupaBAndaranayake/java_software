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

import Model.Admin;
import Model.MydbConnection;

public class AdminController extends Admin implements Controller{
	
	private static Connection con = MydbConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;

	
	private String vehicleId;
	private Map<String,String> key;
	private String AdminId;
	
	public AdminController() {
		super();
	}
	

	//call only AdminId
	public AdminController(String AdminId) {
		super();
		this.AdminId = AdminId;
		
	}

	//creating passwordhashmap method
		public Map<String, String> key(){
			Map<String, String> hashmap = new ConcurrentHashMap<String,String>();
			try {
				pst = con.prepareStatement("SELECT vehicleID,available FROM vehicle");	
			 	rs = pst.executeQuery();
				
				while(rs.next()) {
					String adid = rs.getString("AdminId");
					String pswd = rs.getString("password");
					hashmap.put(adid, pswd);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return hashmap;
			
		}


		@Override
		public void Create() {
			// TODO Auto-generated method stub
			try {
				
				 
				 pst = con.prepareStatement("insert into admins(adminID,adminName,adminUsername,adminPassword)values(?,?,?,?)");
				 pst.setString(1,this.getAdminId());
				 pst.setString(2,this.getName());
				 pst.setString(3,this.getUsername());
				 pst.setString(4,this.getPassword());
				 pst.executeUpdate();
				 
				

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "An error occurred: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
		
		}


		@Override
		public void Delete() {
			// TODO Auto-generated method stub
			try {
				pst = con.prepareStatement("Delete from admins where adminID = ?");
				
				pst.setString(1,this.AdminId);
				pst.executeUpdate();
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}


		@Override
		public void Update() {
			// TODO Auto-generated method stub

			 try {
				pst = con.prepareStatement("update admins set adminName =?, adminUsername=?,adminPassword=? where adminID=?");
				
				 pst.setString(1,this.getName());
				 pst.setString(2,this.getUsername());
				 pst.setString(3,this.getPassword());
				 pst.setString(4,this.getAdminId());
				 pst.executeUpdate();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		public String MaxcusID() {
			String admin = null;
			try {
				pst = con.prepareStatement("SELECT Max(adminID) FROM admins");
				rs = pst.executeQuery();
		        rs.next();
		        admin =rs.getString("Max(adminID)");
		     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return admin;
		}



		@Override
		public Vector<Vector<Object>> Read() {
			// TODO Auto-generated method stub
			Vector<Vector<Object>> data = new Vector<>();
			try{
				
				pst = con.prepareStatement("SELECT * FROM admins WHERE adminID = ?");
				String AdminId = this.AdminId;
				pst.setString(1, AdminId);
				
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
		
		
		
		
}
