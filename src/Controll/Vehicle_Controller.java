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

import Model.MydbConnection;
import Model.Vehicle;

public class Vehicle_Controller extends Vehicle implements CRUD {
	
	private static Connection con = MydbConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private String vehicleId;
	
	
	//default constructor 1
	public Vehicle_Controller(){
		super();
		System.out.println(" in vheicle Controller");
	}
	//oveload 1
	public Vehicle_Controller(String vehicleid) {
		super(vehicleid);
		this.vehicleId = vehicleid;
		
	}
	//overload 2
	public Vehicle_Controller(String vehicleID, String vehicleType,String model,double dailyRate,String fuelType,String available) {
		super(vehicleID,vehicleType,model,dailyRate,fuelType,available);
		this.vehicleId = vehicleID;
	}
	
	//send the daily of the relavant vehicle
	public Double getVehicle_Fee(){
		System.out.println("fetchinf Vehicle and its Fee");
		System.out.println("vehicle ID = " + this.vehicleId);
		Map<String,Double> vehicle_Fee = new ConcurrentHashMap<String,Double>();
		try {
			pst = con.prepareStatement("SELECT vehicleID,dailyRate FROM vehicle");	
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String vehicle_ID = rs.getString("vehicleID");
				Double fee = rs.getDouble("dailyRate");
				vehicle_Fee.put(vehicle_ID, fee);
			}
			
		} catch(SQLException e) {
			System.out.println("Fuck SQL in vehicle Controller  = Vehicle ID HashMap");
			e.printStackTrace();
		}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
		System.out.println("fee is sent");
		return vehicle_Fee.get(this.vehicleId);
	}
	
	public String MaxvehicleID() {
		String VEHI = null;
		try {
			pst = con.prepareStatement("SELECT Max(vehicleID) FROM vehicle");
			rs = pst.executeQuery();
	        rs.next();
	        VEHI =rs.getString("Max(vehicleID)");
	     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VEHI;
	}

	
	//vehicle_availability list
	public  Map<String, String> getVehicle_available(){
		Map<String, String> hashmap = new ConcurrentHashMap<String,String>();
		try {
			pst = con.prepareStatement("SELECT vehicleID,available FROM vehicle");	
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String vid = rs.getString("vehicleID");
				String available = rs.getString("available");
				hashmap.put(vid, available);
			}
			
		} catch(SQLException e) {
			System.out.println("Fuck SQL in vehicle Controller  = Vehicle ID HashMap");
			e.printStackTrace();
		}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
		
		return hashmap;
	}

	
	//update it after returning
	@Override
	public void updateavailabilty(String vehicleID, String call) {
		System.out.println("in upate vehicle availabilty");
		String option1 = "return";
		String option2 = "not return";
		if(call.equals(option1)) {
			try {
				pst = con.prepareStatement("UPDATE vehicle SET available = 'yes' WHERE vehicleID =?");
				pst.setString(1, vehicleID);
				pst.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else if(call.equals(option2)) {
			try {
				pst = con.prepareStatement("UPDATE vehicle SET available = 'no' WHERE vehicleID =?");
				pst.setString(1, vehicleID);
				pst.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Invalid Option");
		}
	}
	
	public void updateavailabilty(String call) {
		System.out.println("updateavailabilty vehicle =  " + this.vehicleId);
		System.out.println("in upate vehicle availabilty");
		String option1 = "return";
		String option2 = "not return";
		if(call.equals(option1)) {
			try {
				pst = con.prepareStatement("UPDATE vehicle SET available = 'yes' WHERE vehicleID =?");
				pst.setString(1, this.vehicleId);
				pst.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else if(call.equals(option2)) {
			try {
				pst = con.prepareStatement("UPDATE vehicle SET available = 'no' WHERE vehicleID =?");
				pst.setString(1, this.vehicleId);
				pst.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Invalid Option");
		}
		System.out.println("/--------------------------------------------/");
		System.out.println("out");
	}
	


	//------------------------------------------------------------------------------------//
	//CRUD-------------------------------------------------------------------------------//
	
	@Override
	public void create() {
		try {
			 pst = con.prepareStatement("insert into vehicle(vehicleID,vehicleType,model,dailyRate,fuelType,available) values(?,?,?,?,?,?)");
			 pst.setString(1,this.getVehicleID());
			 pst.setString(2,this.getVehicleType());
			 pst.setString(3,this.getModel());
			 pst.setDouble(4,this.getDailyRate());
			 pst.setString(5,this.getFuelType());
			 pst.setString(6,this.getAvailable());
			 pst.executeUpdate();
			 
			 
			 JOptionPane.showMessageDialog(null,"Record Was Added Successfully!");
		} catch (SQLException e1) {
			System.out.println("(ADD)FUCK SQL Exception");
			e1.printStackTrace();
		}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }	
		
	}
	
	@Override
	public void update() {
		try {	
			 pst = con.prepareStatement("UPDATE vehicle SET vehicleType=?, model=?, dailyRate=?, fuelType=?, available=? WHERE vehicleID=?");
			 pst.setString(1,this.getVehicleType());
			 pst.setString(2,this.getModel());
			 pst.setDouble(3,this.getDailyRate());
			 pst.setString(4,this.getFuelType());
			 pst.setString(5,this.getAvailable());
			 pst.setString(6,this.getVehicleID());
			 pst.executeUpdate();
			 
			 JOptionPane.showMessageDialog(null,"Record Updated Successfully!");
		} catch (SQLException e) {
			System.out.println("FUCK SQL Exception");
			e.printStackTrace();
		}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
		
	}
	
	@Override
	public void remove() {
		try {
			 pst = con.prepareStatement("Delete from vehicle where vehicleID = ?");
			 System.out.println(this.vehicleId);
			 pst.setString(1,this.vehicleId);
			 pst.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Record deleted."); 
			 
			 
		} catch (SQLException e1) {
			System.out.println("FUCK SQL Exception");
			e1.printStackTrace();
		}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
		
	}
	
	@Override
	public Vector<Vector<Object>> Read() {
		Vector<Vector<Object>> rowDataList = new Vector<>();

	    try {
	        pst = con.prepareStatement("SELECT * FROM vehicle");
	        rs = pst.executeQuery();
	        
	        // Get column information
	 
	        ResultSetMetaData rd = rs.getMetaData();
	        int columnCount = rd.getColumnCount();
	        
	        while (rs.next()) {
	            Vector<Object> rowData = new Vector<>();
	            
	            for (int i = 1; i <= columnCount; i++) {
	                rowData.add(rs.getObject(i));
	            }

	            rowDataList.add(rowData);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error in vehicle_Controller - read() HashMap");
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
	    
		return rowDataList;
	}	

	
	//connection Close
	public void closeConnection() {
	    try {
	        if (con != null) {
	            con.close();
	        }
	    } catch (SQLException e) {
	        System.err.println("Error while closing the database connection");
	        e.printStackTrace();
	    }
	}
}
	
	
	
