package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Controll.CustomerController;
import Controll.Transaction_Controller;
import Controll.Vehicle_Controller;
import Model.MydbConnection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class RegisterFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Connection con = MydbConnection.getConnection();
	private JPanel contentPane;
	private JTextField textcusid;
	private JTextField textfname;
	private JTextField textlname;
	private JTextField textemail;
	private JTextField textnic;
	private JTextField textlic;
	private JTextField textphone;
	private JPanel panel_1;
	private JLabel lblStartdate;
	private JLabel lblEndDate;
	private JPanel panelScreen;
	private JTextField textScreenVID;
	private JTextField textadvancepayment;
	private JTable tablec;
	private JTable tableT;
	private String vehicleID;
	private String customerID;
	private String transactionID;
	private JTextField textDailyRateScreen;
	private JTextField textTotalAmount;
	private JRadioButton rdbtnadavancepayment;
	private JLabel lblAdvancePayment;
	private JRadioButton rdbtnNewRadioButton;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame("V0001");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame(String vehicleID) {
		this.vehicleID = vehicleID;
		System.out.println("catched vehicleID = " + vehicleID);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 422, 723);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerID = new JLabel("Customer ID   : ");
		lblCustomerID.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblCustomerID.setBounds(10, 11, 111, 30);
		panel.add(lblCustomerID);
		
		JLabel lblFirstName = new JLabel("First Name     : ");
		lblFirstName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblFirstName.setBounds(10, 54, 111, 30);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name     : ");
		lblLastName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblLastName.setBounds(10, 90, 111, 30);
		panel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email             : ");
		lblEmail.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEmail.setBounds(10, 131, 111, 30);
		panel.add(lblEmail);
		
		JLabel lblNic = new JLabel(" NIC              : ");
		lblNic.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblNic.setBounds(10, 172, 111, 30);
		panel.add(lblNic);
		
		JLabel lblLic = new JLabel(" LIC               : ");
		lblLic.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblLic.setBounds(10, 213, 111, 30);
		panel.add(lblLic);
		
		JLabel lblPhone = new JLabel("Phone          : ");
		lblPhone.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblPhone.setBounds(10, 254, 111, 30);
		panel.add(lblPhone);
		
		textcusid = new JTextField();
		textcusid.setBounds(131, 14, 154, 30);
		panel.add(textcusid);
		textcusid.setColumns(10);
		
		textfname = new JTextField();
		textfname.setColumns(10);
		textfname.setBounds(131, 57, 154, 30);
		panel.add(textfname);
		
		textlname = new JTextField();
		textlname.setColumns(10);
		textlname.setBounds(131, 93, 154, 30);
		panel.add(textlname);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(131, 134, 154, 30);
		panel.add(textemail);
		
		textnic = new JTextField();
		textnic.setColumns(10);
		textnic.setBounds(131, 175, 154, 30);
		panel.add(textnic);
		
		textlic = new JTextField();
		textlic.setColumns(10);
		textlic.setBounds(131, 216, 154, 30);
		panel.add(textlic);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(131, 257, 154, 30);
		panel.add(textphone);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Payment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 327, 402, 374);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblStartdate = new JLabel("Start Date    : ");
		lblStartdate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblStartdate.setBounds(10, 25, 111, 23);
		panel_1.add(lblStartdate);
		
		
		lblEndDate = new JLabel("End Date     : ");
		lblEndDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEndDate.setBounds(10, 59, 111, 23);
		panel_1.add(lblEndDate);
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(119, 25, 143, 23);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		panel_1.add(dateChooser1);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(119, 59, 143, 23);
		dateChooser2.setDateFormatString("yyyy-MM-dd");
		panel_1.add(dateChooser2);
		
		panelScreen = new JPanel();
		panelScreen.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelScreen.setBounds(10, 132, 363, 135);
		panel_1.add(panelScreen);
		panelScreen.setLayout(null);
	
		
		textScreenVID = new JTextField();
		textScreenVID.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		textScreenVID.setBounds(10, 11, 343, 31);
		panelScreen.add(textScreenVID);
		textScreenVID.setColumns(10);
		
		textDailyRateScreen = new JTextField();
		textDailyRateScreen.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		textDailyRateScreen.setColumns(10);
		textDailyRateScreen.setBounds(10, 53, 343, 31);
		panelScreen.add(textDailyRateScreen);
		
		textTotalAmount = new JTextField();
		textTotalAmount.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		textTotalAmount.setColumns(10);
		textTotalAmount.setBounds(10, 95, 343, 31);
		panelScreen.add(textTotalAmount);
		
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction_Controller trans = new Transaction_Controller(vehicleID);
				SimpleDateFormat DateFormat =new SimpleDateFormat("yyyy-MM-dd");
				String StartDate = DateFormat.format(dateChooser1.getDate());
				String EndDate = DateFormat.format(dateChooser2.getDate());
				
				Double Total_Amount = trans.calculateTotalAmount(StartDate, EndDate);
				Date Start = null;
				try {
					Start = DateFormat.parse(StartDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Date endDate = null;
				try {
					endDate = DateFormat.parse(EndDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				int differenceInDays = (int) ChronoUnit.DAYS.between(Start.toInstant(), endDate.toInstant());
		        
				if(differenceInDays == 1){
		    	   textScreenVID.setText("Vehicle ID  " + vehicleID + " For a Day " );
				}else {
		    	   textScreenVID.setText("Vehicle ID  " + vehicleID + " For " + differenceInDays + " Days " );
				} 
				System.out.println(vehicleID);
		        Vehicle_Controller vehi = new Vehicle_Controller(vehicleID);
		        textDailyRateScreen.setText("Daily Rate = " + vehi.getVehicle_Fee());
		        textTotalAmount.setText("Total Amount = " + Total_Amount);
			}
		});
		btnDisplay.setBounds(10, 93, 111, 28);
		panel_1.add(btnDisplay);
			
	    lblAdvancePayment = new JLabel("Advance payment  : ");
		lblAdvancePayment.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblAdvancePayment.setBounds(10, 298, 157, 23);
		lblAdvancePayment.setVisible(false);
		panel_1.add(lblAdvancePayment);
		
		textadvancepayment = new JTextField();
		textadvancepayment.setBounds(154, 301, 149, 22);
		textadvancepayment.setVisible(false);
		panel_1.add(textadvancepayment);
		textadvancepayment.setColumns(10);
		
		rdbtnadavancepayment = new JRadioButton("Advance Payment");
		RadioButtonAction();
		rdbtnadavancepayment.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		rdbtnadavancepayment.setBounds(10, 274, 179, 23);
		panel_1.add(rdbtnadavancepayment);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rent r = new Rent();
				r.setVisible(true);
			}
		});
		btnReturn.setBounds(272, 333, 111, 30);
		panel_1.add(btnReturn);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(151, 333, 111, 30);
		panel_1.add(btnReset);
		
		JButton btnadd = new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnadd.setBounds(10, 333, 110, 30);
		panel_1.add(btnadd);
		
		rdbtnNewRadioButton = new JRadioButton("Mutliple purchases\r\n");
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		rdbtnNewRadioButton.setBounds(20, 297, 265, 23);
		panel.add(rdbtnNewRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(442, 11, 668, 322);
		contentPane.add(scrollPane);
		
		tablec = new JTable();
		tablec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tablec.getModel();
				
				int selectedIndex = tablec.getSelectedRow();
				
				textcusid.setText(model.getValueAt(selectedIndex, 0).toString());
				textfname.setText(model.getValueAt(selectedIndex, 1).toString());
				textlname.setText(model.getValueAt(selectedIndex, 2).toString());
				textemail.setText(model.getValueAt(selectedIndex, 4).toString());
				textnic.setText(model.getValueAt(selectedIndex,5).toString());
				textlic.setText(model.getValueAt(selectedIndex,6).toString());
				textphone.setText(model.getValueAt(selectedIndex, 3).toString());
			}
		});
		tablec.setToolTipText("");
		tablec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablec.setBackground(new Color(220, 220, 220));
		tablec.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tablec.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, "", null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"customerID", "firstName", "lastName", "phoneNumber", "email", "NIC", "LIC"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablec.getColumnModel().getColumn(1).setPreferredWidth(106);
		tablec.getColumnModel().getColumn(2).setPreferredWidth(111);
		tablec.getColumnModel().getColumn(3).setPreferredWidth(98);
		scrollPane.setViewportView(tablec);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Transactions", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1.setBounds(442, 334, 668, 378);
		contentPane.add(scrollPane_1);
		
		tableT = new JTable();
		tableT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tableT.getModel();
				
				int selectedIndex = tableT.getSelectedRow();
				
				textcusid.setText(model.getValueAt(selectedIndex, 0).toString());
				textfname.setText(model.getValueAt(selectedIndex, 1).toString());
				textlname.setText(model.getValueAt(selectedIndex, 2).toString());
				textemail.setText(model.getValueAt(selectedIndex, 4).toString());
				textnic.setText(model.getValueAt(selectedIndex,5).toString());
				textlic.setText(model.getValueAt(selectedIndex,6).toString());
				textphone.setText(model.getValueAt(selectedIndex, 3).toString());
				String String_Start = model.getValueAt(selectedIndex, 1).toString();
				String String_End = model.getValueAt(selectedIndex, 2).toString();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format as needed

				try {
					Date Start = dateFormat.parse(String_Start);
					dateChooser1.setDate(Start);
					Date End = dateFormat.parse(String_End);
					dateChooser2.setDate(End);
				}catch(ParseException  e) {
					e.printStackTrace();
				}
			}
		});
		tableT.setToolTipText("");
		tableT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableT.setBackground(new Color(220, 220, 220));
		tableT.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tableT.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", null, null, ""},
				{null, null, null, null, null, null, null},
				{"", "", null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, ""},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"transactionID", "rentalStartDate", "rentalEndDate", "returnStatus", "totalAmount", "advancePaid", "dueAmount"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableT.getColumnModel().getColumn(1).setPreferredWidth(91);
		tableT.getColumnModel().getColumn(2).setPreferredWidth(91);
		tableT.getColumnModel().getColumn(3).setPreferredWidth(82);
		scrollPane_1.setViewportView(tableT);
		
		Cautoid();
		Ctable_update();
		Ttable_update();
		
	}
	public void RadioButtonAction() {
		rdbtnadavancepayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnadavancepayment.isSelected()) {
					lblAdvancePayment.setVisible(true);
					textadvancepayment.setVisible(true);
                }else {
                    lblAdvancePayment.setVisible(false);
                    textadvancepayment.setVisible(false);
                }
			}
		});
	}
	
	public void MultiplePurchaseRadioButton() {
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
	}
	
	public void setRadioButton() {
		 lblAdvancePayment.setVisible(false);
         textadvancepayment.setVisible(false);
	}
	public void add() {
		//customer
		String cusid= textcusid.getText();
		
		if(rdbtnNewRadioButton.isSelected()) {
			System.out.println("In if statement of radio button");
			Transaction_Controller trans = new Transaction_Controller(vehicleID,cusid);
			String transactionID = generateTransactionID(trans.LasttransID());//seting the tranasaction value for this frame 
			trans.setTransactionId(transactionID);//sending the last transaction and seting value
			
			System.out.println("last = " + trans.LasttransID());
			System.out.println("new = " + generateTransactionID(trans.LasttransID()) );
			System.out.println("transaction ID = " + transactionID);
			
			System.out.println("vehicleID = " + this.vehicleID);
			trans.setVehicleID(this.vehicleID);
			trans.setCustomerID(textcusid.getSelectedText());
			
			SimpleDateFormat DateFormat =new SimpleDateFormat("yyyy-MM-dd");
			String StartDate = DateFormat.format(dateChooser1.getDate());
			String EndDate = DateFormat.format(dateChooser2.getDate());
			
			trans.setRentalStartDate(StartDate);
			trans.setRentalEndDate(EndDate);
			trans.setReturnStatus("not return");
			
			double tot = trans.calculateTotalAmount(StartDate, EndDate);
			trans.setTotalAmount(tot);
			
			String advanceString = textadvancepayment.getText();
			System.out.println("advance text box = " + advanceString);
			if (advanceString != null) {
				System.out.println("in if");
				trans.setAdvancePaid(0);
			   	trans.setDueAmount(tot);
			} else {
				System.out.println("in else");
				double Advance = Double.parseDouble(advanceString);
				
				if(Advance > tot) {
					setRadioButton();
				}
				//checking whether the entered advance is greater than the total amoun
				while (Advance > tot) {
				    System.out.println("error!");
				    JOptionPane.showMessageDialog(null, "Invalid Advance!", "Warning", JOptionPane.ERROR_MESSAGE);
				    textadvancepayment.setText("");
				    String newAdvance = JOptionPane.showInputDialog("Enter a valid Advance Amount:");
				   
				    try {
				        Advance = Double.parseDouble(newAdvance);
				    } catch (NumberFormatException e) {
				        Advance = 0.0; 
				    }
				}
				trans.setAdvancePaid(Advance);
				trans.setDueAmount(tot - Advance);
				trans.create();
			}
		}else {
			
			System.out.println("In else statement of radio button");
			String fname= textfname.getText();
			String lname= textlname.getText();
			String pno= textphone.getText();
			String email= textemail.getText();
			String  nic = textnic.getText();
			String lic = textlic.getText();

			Transaction_Controller trans = new Transaction_Controller(vehicleID,cusid);
			String transactionID = generateTransactionID(trans.LasttransID());//seting the tranasaction value for this frame 
			trans.setTransactionId(transactionID);//sending the last transaction and seting value
			trans.setVehicleID(this.vehicleID);
			trans.setCustomerID(textcusid.getSelectedText());
			
			SimpleDateFormat DateFormat =new SimpleDateFormat("yyyy-MM-dd");
			String StartDate = DateFormat.format(dateChooser1.getDate());
			String EndDate = DateFormat.format(dateChooser2.getDate());
			
			trans.setRentalStartDate(StartDate);
			trans.setRentalEndDate(EndDate);
			trans.setReturnStatus("not return");
			
			double tot = trans.calculateTotalAmount(StartDate, EndDate);
			trans.setTotalAmount(tot);
			
			String advanceString = textadvancepayment.getText();
			System.out.println("advance text box = " + advanceString);
			if (advanceString != null) {
				System.out.println("in if");
				trans.setAdvancePaid(0);
			   	trans.setDueAmount(tot);
			} else {
				System.out.println("in else");
				double Advance = Double.parseDouble(advanceString);
				
				if(Advance > tot) {
					setRadioButton();
				}
				//checking whether the entered advance is greater than the total amoun
				while (Advance > tot) {
				    System.out.println("error!");
				    JOptionPane.showMessageDialog(null, "Invalid Advance!", "Warning", JOptionPane.ERROR_MESSAGE);
				    textadvancepayment.setText("");
				    String newAdvance = JOptionPane.showInputDialog("Enter a valid Advance Amount:");
				   
				    try {
				        Advance = Double.parseDouble(newAdvance);
				    } catch (NumberFormatException e) {
				        Advance = 0.0; 
				    }
				}
				trans.setAdvancePaid(Advance);
				trans.setDueAmount(tot - Advance);
			}
			CustomerController cus = new CustomerController(cusid,fname,lname,pno,email,nic,lic);
			cus.create();//adding to the customer database
			trans.create();
		}
		textcusid.setText("");
		textfname.setText("");
		textlname.setText("");
		textemail.setText("");
		textnic.setText("");
		textlic.setText("");
		textphone.setText("");
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);
		textScreenVID.setText("");
		textDailyRateScreen.setText("");
		textTotalAmount.setText("");
		textadvancepayment.setText("");

		
		Cautoid();
		Ctable_update();
		Ttable_update();
		
		Transaction_Controller TVC = new Transaction_Controller(transactionID,this.vehicleID,cusid);
		TVC.add_transaction_vehicle_customer();
	}
	
	public void reset() {
		
		textcusid.setText("");
		textfname.setText("");
		textlname.setText("");
		textemail.setText("");
		textnic.setText("");
		textlic.setText("");
		textphone.setText("");
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);
		textScreenVID.setText("");
		textDailyRateScreen.setText("");
		textTotalAmount.setText("");
		textadvancepayment.setText("");
		
		Cautoid();
		Ctable_update();
		Ttable_update();
	}

	//increment the String by one
	public String generateTransactionID(String transid){
		int numericPart = Integer.parseInt(transid.substring(1));
		numericPart++;
		String Next_ID = String.format("T%04d",numericPart);
		
		return Next_ID;
	}
	
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public void Ctable_update() {
		DefaultTableModel df = (DefaultTableModel) tablec.getModel();
          // Clear the existing rows in the table
		df.setRowCount(0);
          
		CustomerController cus = new CustomerController();
		Vector<Vector<Object>> data = cus.Read();
          
		for(Vector<Object> rowData: data) {	
			df.addRow(rowData);
		}
	}
	
	public void Cautoid() {
		CustomerController cus = new CustomerController();
		String max = cus.MaxcusID();
		System.out.println(max);
		
		 if(max==null) {
         	textcusid.setText("C0001");
         }else {
         	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
             String numericPart = max.substring(1);

             // Parse the numeric portion as a long
             long id = Long.parseLong(numericPart);

             // Increment the ID to get the next value
             id ++;
             System.out.println(id);
             textcusid.setText("C"+ String.format("%04d",id));
         }
	}

	public void Ttable_update() {
		DefaultTableModel df = (DefaultTableModel) tableT.getModel();
        // Clear the existing rows in the table
		df.setRowCount(0);
        
		Transaction_Controller transaction = new Transaction_Controller();
		Vector<Vector<Object>> data = transaction.Read_transaction();
        
		for(Vector<Object> rowData: data) {	
			df.addRow(rowData);
		}
	}
}
