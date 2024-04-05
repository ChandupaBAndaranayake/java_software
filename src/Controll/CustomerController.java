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

import Model.Customer;
import Model.MydbConnection;

public  class CustomerController extends Customer implements CRUD {
	//db connection
	private static Connection con = MydbConnection.getConnection();
	private static PreparedStatement pst;
	private static ResultSet rs;
	private String customerID;
	
	//default constructor 1
	public CustomerController() {
		super();
		System.out.println("Customer_Contoller");
	}
	//oveload 1
	public CustomerController(String customerID) {
		super(customerID);
		this.customerID = customerID;
	}
	//overload 2
	public CustomerController(String customerId, String firstName, String lastName, String phoneNumber, String email,String nic ,String lic) {
		super(customerId, firstName, lastName, phoneNumber, email , nic , lic);
		this.customerID = customerId;
		
	}
	//vehicle list 
	public  Vector<String> getvehicleList(String selectedCUSID){
		Vector<String> vehicleList = new Vector<String>();
		try {
			pst = con.prepareStatement("SELECT vehicleID FROM transaction_vehicle_customer WHERE customerID = ?");
			pst.setString(1, selectedCUSID);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String available = rs.getString("available");
				vehicleList.add(available);
			}
			
		} catch(SQLException e) {
			System.out.println("Fuck SQL in Customer Controller  = VehicleList HashMap");
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
		return vehicleList;
	}
	
	//get the TRansID_VehicleID
	public Map<String,String> getTransID_vehicID_List(Vector<String> vehicleList){
		Map<String, String> TransID_vehicID = new ConcurrentHashMap<String,String>();
		//the query
		String sqlquery = "SELECT transactionID,vehicleID FROM transaction_vehicle_customer where vehicleID = ?";
		try {
			for(String VID:vehicleList) {
				//creating a prepared statement
				pst = con.prepareStatement(sqlquery);
				pst.setString(1, VID);
				
				
				//executing the query
				rs = pst.executeQuery();
				
				//adding Vid and transID to the hashmap
				while(rs.next()) {
					String vid = rs.getString("vehicleID");
					String transID = rs.getString("transactionID");
					TransID_vehicID.put(vid, transID);
				}
				
			}
		} catch(SQLException e) {
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
		return TransID_vehicID;
	} 
	
	//------------------------------------------------------------------------------------//
	//CRUD-------------------------------------------------------------------------------//
	@Override
	public void create() {
		System.out.println("Add in the customer");
		try {
			 pst = con.prepareStatement("insert into customer(customerID,firstName,lastName,phoneNumber,email,NIC,LIC) values(?,?,?,?,?,?,?)");
			 pst.setString(1,this.getCustomerId());
			 pst.setString(2,this.getFirstName());
			 pst.setString(3,this.getLastName());
			 pst.setString(4,this.getPhoneNumber());
			 pst.setString(5,this.getEmail());
			 pst.setString(6,this.getNIC());
			 pst.setString(7,this.getLIC());
			 pst.executeUpdate();
			 
			 JOptionPane.showMessageDialog(null,"The Customer Recode Was Added Successfully!");

		} catch (SQLException e1) {
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
		System.out.println("Finish adding the customer");
	}

	@Override
	public void remove() {
		try {
			
			 pst = con.prepareStatement("Delete from customer where customerID = ?");
			 System.out.println(this.customerID);
			 pst.setString(1,this.customerID);
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
	public void remove(String customerID) {
		System.out.println(customerID);
		System.out.println("in Remove");
		try {
			con.setAutoCommit(false);
			Vector<String> cuslist = new Vector<>();
			pst = con.prepareStatement("Select customerID from transaction_vehicle_customer ");
			rs = pst.executeQuery();
			
			while(rs.next()){
				String TID = rs.getString("customerID");
				cuslist.add(TID);
			}
			
			for(String str:cuslist) {
				System.out.println(str);
			}
			
			if(cuslist.contains(customerID)) {
				System.out.println("in if ");
				
				pst = con.prepareStatement("DELETE FROM transaction_vehicle_customer WHERE customerID = ? ");
				pst.setString(1,customerID);
				pst.executeUpdate();
			
				pst = con.prepareStatement("DELETE FROM customer WHERE customerID = ?");
				pst.setString(1,customerID);
				pst.executeUpdate();
				
				
			}else {
				System.out.println("in else");
				
				pst = con.prepareStatement("DELETE FROM customer WHERE customerID = ?");
				pst.setString(1,customerID);
				pst.executeUpdate();
				
			}
			int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want save the changes?", "Warning", JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == JOptionPane.YES_OPTION) {
				con.commit();
				JOptionPane.showMessageDialog(null,"Record deleted."); 
			}else {
				con.rollback();
				JOptionPane.showMessageDialog(null,"Records unchange!"); 
			}
			con.commit();
			}catch(SQLException e) {
				e.printStackTrace();
				try {
					con.rollback(); 
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
			}finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	            con.setAutoCommit(true); 
	        } catch (SQLException e) {
	            System.err.println("Error while closing resources");
	            e.printStackTrace();
	        }
	    }
	}
	
	public String MaxcusID() {
		String CUS = null;
		try {
			pst = con.prepareStatement("SELECT Max(customerID) FROM customer");
			rs = pst.executeQuery();
	        rs.next();
	        CUS =rs.getString("Max(customerID)");
	     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CUS;
	}

	@Override
	public void update() {
		try {	
			 pst = con.prepareStatement("UPDATE customer SET firstName=?, lastName=?, phoneNumber=?, email=?, NIC=?, LIC=? WHERE customerID=?");
			 pst.setString(1, this.getFirstName());
			 pst.setString(2, this.getLastName());
			 pst.setString(3, this.getPhoneNumber());
			 pst.setString(4, this.getEmail());
			 pst.setString(5, this.getNIC());
			 pst.setString(6, this.getLIC());
			 pst.setString(7,this.getCustomerId());
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
	public Vector<Vector<Object>> Read() {
		// TODO Auto-generated method stub
		//System.out.println("CID  " + this.customerID);
		Vector<Vector<Object>> rowDataList = new Vector<>();
			try {
				pst = con.prepareStatement("SELECT * FROM customer");
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
				System.out.println("Error in Customer_Controller - read() HashMap");
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
	
	//Connection close
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
