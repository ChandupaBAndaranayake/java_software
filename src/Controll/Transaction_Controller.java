package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.swing.JOptionPane;

import Model.MydbConnection;
import Model.Transaction;

public class Transaction_Controller extends Transaction implements CRUD {

	private static Connection con = MydbConnection.getConnection();
	private static PreparedStatement pst;
	private static Statement s;
	private static ResultSet rs;
	private String transactionID;
	private String vehicleID;
	private String customerID;

	public Transaction_Controller() {
		super();
		System.out.println("Default Transaction Controller");
	}

	public Transaction_Controller(String vehicleID, String customerID) {
		this.vehicleID = vehicleID;
		this.customerID = customerID;
	}

	public Transaction_Controller(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public void Transaction_Controller1(String transactionID) {
		
		
	}

	public Transaction_Controller(String transactionID, String vehicleID, String customerID) {
		super();
		this.transactionID = transactionID;
		this.vehicleID = vehicleID;
		this.customerID = customerID;
	}

	public Transaction_Controller(String transactionId, String rentalStartDate, String rentalEndDate,
			double totalAmount, double advancePaid, double dueAmount, String returnStatus) {
		super(transactionId, rentalStartDate, rentalEndDate, totalAmount, advancePaid, dueAmount, returnStatus);
		this.transactionID = transactionId;
		System.out.println("Overloaded constructor");
	}

	public Vector<String> getCusvehicList(String customerID) {
		System.out.println("vehicle list");
		Vector<String> vehiclelist = new Vector<>();
		try {
			pst = con.prepareStatement("SELECT vehicleID from transaction_vehicle_customer where customerID=? ");
			pst.setString(1, customerID);

			rs = pst.executeQuery();
			while (rs.next()) {
				String CID = rs.getString("vehicleID");
				vehiclelist.add(CID);
			}
		} catch (SQLException e) {
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
		System.out.println("sent list");
		return vehiclelist;
	}

	// calcultate total Amount of the relavant order
	public Double calculateTotalAmount(String rentalStartDate, String rentalEndDate) {
		// should take the VEhicle ID first
		Vehicle_Controller vehi = new Vehicle_Controller(this.vehicleID);
		// then take its Fee
		Double fee = vehi.getVehicle_Fee();
		// then Take the Time Difference between it
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Parse the date strings into LocalDate objects
		LocalDate startDate = LocalDate.parse(rentalStartDate, formatter);
		LocalDate endDate = LocalDate.parse(rentalEndDate, formatter);

		// Calculate the difference in days as an integer
		int differenceInDays = (int) ChronoUnit.DAYS.between(startDate, endDate);

		// then Take the multiply the fee by it
		Double Total_Amount = differenceInDays * fee;

		// return the Total amount
		System.out.println("total _amount = " + Total_Amount);
		return Total_Amount;
	}

	// send the last transaction ID
	public String LasttransID() {
		System.out.println("fetching trans id");
		Vector<String> transId = new Vector<>();
		System.out.println("Last transID = " + this.transactionID);
		try {
			String sqlquery = "SELECT transactionID FROM transaction";
			pst = con.prepareStatement(sqlquery);
			rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("transactionID");
				transId.add(id);
			}

			Collections.reverse(transId);
			for (String s : transId) {
				System.out.println(s);
			}
		} catch (SQLException e) {
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
		System.out.println("element at Zero = " + transId.elementAt(0));
		this.transactionID = transId.elementAt(0);
		System.out.println("last ID = " + transId.elementAt(0));
		return transId.elementAt(0);

	}

	public String MaxtransID() {
		String VID = null;
		try {
			pst = con.prepareStatement("SELECT Max(transactionID) FROM transaction");
			rs = pst.executeQuery();
			rs.next();
			VID = rs.getString("Max(transactionID)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VID;
	}

	@Override
	public void create() {
		try {
			System.out.println("in create of Transaction");
			pst = con.prepareStatement(
					"insert into transaction(transactionID,rentalStartDate, rentalEndDate , returnStatus , totalAmount , advancePaid , dueAmount) values(?,?,?,?,?,?,?)");
			pst.setString(1, this.getTransactionId());
			pst.setString(2, this.getRentalStartDate());
			pst.setString(3, this.getRentalEndDate());
			pst.setString(4, this.getReturnStatus());
			pst.setDouble(5, this.getTotalAmount());
			pst.setDouble(6, this.getAdvancePaid());
			pst.setDouble(7, this.getDueAmount());
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "The Transaction Recode Was Added Successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
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
	}

	public void remove(String transactionID) {
		System.out.println(transactionID);
		System.out.println("in Remove");
		try {
			con.setAutoCommit(false);
			Vector<String> translist = new Vector<>();
			pst = con.prepareStatement("Select transactionID from transaction_vehicle_customer ");
			rs = pst.executeQuery();

			while (rs.next()) {
				String TID = rs.getString("transactionID");
				translist.add(TID);
			}

			for (String str : translist) {
				System.out.println(str);
			}

			if (translist.contains(transactionID)) {
				System.out.println("in if ");

				pst = con.prepareStatement("DELETE FROM transaction_vehicle_customer WHERE transactionID = ? ");
				pst.setString(1, transactionID);
				pst.executeUpdate();

				pst = con.prepareStatement("DELETE FROM transaction WHERE transactionID = ?");
				pst.setString(1, transactionID);
				pst.executeUpdate();

			} else {
				System.out.println("in else");

				pst = con.prepareStatement("DELETE FROM transaction WHERE transactionID = ?");
				pst.setString(1, transactionID);
				pst.executeUpdate();

			}
			int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want save the changes?", "Warning",
					JOptionPane.YES_NO_OPTION);

			if (dialogResult == JOptionPane.YES_OPTION) {
				con.commit();
				JOptionPane.showMessageDialog(null, "Record deleted.");
			} else {
				con.rollback();
				JOptionPane.showMessageDialog(null, "Records unchange!");
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException sql) {
				sql.printStackTrace();
			}
		} finally {
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

	@Override
	public void update() {
		try {
			pst = con.prepareStatement(
					"UPDATE transaction SET rentalStartDate=?, rentalEndDate=?, returnStatus=?, totalAmount=?, advancePaid=? , dueAmount=? WHERE transactionID=?");
			pst.setString(1, this.getRentalStartDate());
			pst.setString(2, this.getRentalEndDate());
			pst.setString(3, this.getReturnStatus());
			pst.setDouble(4, this.getTotalAmount());
			pst.setDouble(5, this.getAdvancePaid());
			pst.setDouble(6, this.getDueAmount());
			pst.setString(7, this.getTransactionId());
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
		} catch (SQLException e) {
			System.out.println("FUCK SQL Exception");
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

	}

	@Override
	public Vector<Vector<Object>> Read() {
		Vector<Vector<Object>> rowDataList = new Vector<>();

		try {
			pst = con.prepareStatement("SELECT * FROM transaction_vehicle_customer");
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
			System.out.println("Error in Transaction_Controller - read() HashMap");
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


	public Vector<Vector<Object>> Read_transaction() {
		Vector<Vector<Object>> rowDataList = new Vector<>();
			try {
				pst = con.prepareStatement("SELECT * FROM transaction");
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
	

	// add to Transaction_vehicle_customer
	public void add_transaction_vehicle_customer() {
		System.out.println(this.transactionID + " " + this.vehicleID + " " + this.customerID);
		try {
			pst = con.prepareStatement(
					"insert into transaction_vehicle_customer(transactionID,vehicleID,customerID) values(?,?,?)");
			pst.setString(1, this.transactionID);
			pst.setString(2, this.vehicleID);
			pst.setString(3, this.customerID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
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
	}

	public String getTransID(String VID) {
		String transID = null;

		try {
			pst = con.prepareStatement("SELECT transactionID FROM transaction_vehicle_customer WHERE vehicleID=?");
			pst.setString(1, VID);
			rs = pst.executeQuery();

			while (rs.next()) {
				transID = rs.getString("transactionID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return transID;
	}

	// get customers _ vehicle , return vehicle_tip map
	public Map<String, String> getCustomer_vehicle(String customerID) {
		Map<String, String> cus_vehicle = new ConcurrentHashMap<String, String>();
		try {
			pst = con.prepareStatement(
					"select customerID,vehicleID FROM transaction_vehicle_customer where customerID =?");
			pst.setString(1, customerID);
			rs = pst.executeQuery();

			while (rs.next()) {
				String TID = rs.getString("transactionID");
				String VID = rs.getString("vehicleID");
				cus_vehicle.put(TID, VID);
			}

		} catch (SQLException e) {
			System.out.println("Fuck SQL in vehicle Controller  = Vehicle ID HashMap");
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
		return cus_vehicle;
	}

	public Set<String> getVehicle(String customerID) {
		System.out.println("Inside threade safe vehicle list");
		Set<String> vehiclelist = new ConcurrentSkipListSet<>();
		try {
			pst = con.prepareStatement("SELECT vehicleID FROM transaction_vehicle_customer WHERE customerID =?");
			pst.setString(1, customerID);

			rs = pst.executeQuery();
			while (rs.next()) {
				String VID = rs.getString("vehicleID");
				vehiclelist.add(VID);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("/-----------------------------/");
		System.out.println("outdfgdfgff");
		return vehiclelist;
	}

	public Double GetDueAmount(String transactionID) {
		Double DueAmount = 0.0;
		try {
			pst = con.prepareStatement("SELECT dueAmount FROM transaction WHERE transactionID =?");
			pst.setString(1, transactionID);
			rs = pst.executeQuery();

			while (rs.next()) {
				DueAmount = rs.getDouble("dueAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DueAmount;
	}

	public Vector<String> getTranslist() {
		System.out.println("inside getTranslit");
		System.out.println("-----------------------");
		Vector<String> translist = new Vector<>();
		try {
			pst = con.prepareStatement("SELECT transactionID FROM transaction_vehicle_customer WHERE customerID =?");
			pst.setString(1, this.customerID);
			rs = pst.executeQuery();
			while (rs.next()) {
				String TID = rs.getString("transactionID");
				translist.add(TID);
			}
		} catch (SQLException e) {
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
		System.out.println("out1");
		return translist;
	}

	// antoher form of list that make list for CIDS
	public Vector<String> getTransList(String CID) {
		System.out.println("inside getTranslit");
		System.out.println("-----------------------");
		Vector<String> translist = new Vector<>();
		try {
			pst = con.prepareStatement("SELECT transactionID FROM transaction_vehicle_customer WHERE customerID =?");
			pst.setString(1, CID);
			rs = pst.executeQuery();
			while (rs.next()) {
				String TID = rs.getString("transactionID");
				translist.add(TID);
			}
		} catch (SQLException e) {
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
		System.out.println("out2");
		return translist;
	}

	public Double totalAmountlist(String transactionID) {
		Double totalAmountlist = 0.0;
		try {
			pst = con.prepareStatement("SELECT dueAmount FROM transaction WHERE transactionID =?");
			pst.setString(1, this.transactionID);
			rs = pst.executeQuery();

			totalAmountlist = rs.getDouble("dueAmount");

		} catch (SQLException e) {
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
		return totalAmountlist;
	}

	public void updateTransactionStatus(String transactionID, String call) {
		System.out.println("in upate transaction status");
		System.out.println("Transaction ID -> " + transactionID);
		String option1 = "return";
		String option2 = "not return";
		if (call.equals(option1)) {
			try {
				pst = con.prepareStatement("UPDATE transaction SET returnStatus = 'Return' WHERE transactionID =?");
				pst.setString(1, transactionID);
				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (call.equals(option2)) {
			try {
				pst = con.prepareStatement("UPDATE transaction SET returnStatus = 'not return' WHERE transactionID =?");
				pst.setString(1, transactionID);
				pst.executeUpdate();

				JOptionPane.showMessageDialog(null, "Record Updated Successfully!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Option");
		}
		System.out.println("/--------------------------------------------/");
		System.out.println("out4");
	}

	public Set<String> getcusList() {
		System.out.println("cuslist");
		Set<String> cuslist = new ConcurrentSkipListSet<>();
		try {
			pst = con.prepareStatement("SELECT customerID FROM transaction_vehicle_customer");
			rs = pst.executeQuery();

			while (rs.next()) {
				String CID = rs.getString("customerID");
				cuslist.add(CID);
			}
		} catch (SQLException e) {
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
		System.out.println("cuslist is sent");
		return cuslist;
	}

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

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		try {
			System.out.println("TID " + this.transactionID);
			pst = con.prepareStatement("Delete from transaction where transactionID = ?");
			pst.setString(1,this.transactionID);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
			e.printStackTrace();
		}

	}
}
