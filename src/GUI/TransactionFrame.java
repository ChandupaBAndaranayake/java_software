package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controll.Transaction_Controller;
import Model.MydbConnection;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class TransactionFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Connection con = MydbConnection.getConnection();
	private JPanel contentPane;
	private JTextField txtTransactionID;
	private JTextField txtAdvancePay;
	private JTextField txtTotAmnt;
	private JTable table;
	private JTextField txtDueAmnt;
	private JComboBox<String> comboReturnStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionFrame frame = new TransactionFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    ////////////////////////////////
	//Function to ADD values to the Table
	public void table_update() {
		DefaultTableModel df = (DefaultTableModel) table.getModel();
        // Clear the existing rows in the table
        df.setRowCount(0);
        
        Transaction_Controller trans = new Transaction_Controller();
        Vector<Vector<Object>> data = trans.Read_transaction();
        
        for(Vector<Object> rowData: data) {
        	df.addRow(rowData);
        }
        System.out.println("out table update");
	}
	
	//auto generate ID
	public void autoid() {
		Transaction_Controller trans = new Transaction_Controller();
		String TID = trans.MaxtransID();
		if(TID==null) {
			txtTransactionID.setText("T0001");
        }else {
        	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
            String numericPart = TID.substring(1);

            // Parse the numeric portion as a long
            long id = Long.parseLong(numericPart);

            // Increment the ID to get the next value
            id ++;
            
            txtTransactionID.setText("T"+ String.format("%04d",id));
        }
	}
	 /////////////////////////////////
	 /* Create the frame.
	 */
	public TransactionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Transaction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 875, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTransactionID = new JLabel("Transaction ID");
		lblTransactionID.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblTransactionID.setBounds(10, 39, 111, 23);
		panel.add(lblTransactionID);
		
		JLabel lblRentalStartDate = new JLabel("Rental Start Date ");
		lblRentalStartDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblRentalStartDate.setBounds(10, 73, 111, 42);
		panel.add(lblRentalStartDate);
		
		JLabel lblRentalEndDate = new JLabel("Rental End Date ");
		lblRentalEndDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblRentalEndDate.setBounds(10, 126, 111, 42);
		panel.add(lblRentalEndDate);
		
		JLabel lblRentalStartDate_1_1 = new JLabel("Advanced Paid");
		lblRentalStartDate_1_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblRentalStartDate_1_1.setBounds(10, 212, 111, 23);
		panel.add(lblRentalStartDate_1_1);
		
		JLabel lblRentalStartDate_1_1_1 = new JLabel("Total Amount     ");
		lblRentalStartDate_1_1_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblRentalStartDate_1_1_1.setBounds(10, 291, 111, 23);
		panel.add(lblRentalStartDate_1_1_1);
		
		JLabel lblDueAmnt = new JLabel("Amount Due ");
		lblDueAmnt.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblDueAmnt.setBounds(10, 249, 111, 24);
		panel.add(lblDueAmnt);
		
		JLabel lblRentalStartDate_1_1_2 = new JLabel("Return Status");
		lblRentalStartDate_1_1_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblRentalStartDate_1_1_2.setBounds(10, 179, 111, 13);
		panel.add(lblRentalStartDate_1_1_2);
		
		comboReturnStatus = new JComboBox<>();
		comboReturnStatus.setBounds(124, 172, 127, 28);
		panel.add(comboReturnStatus);
		comboReturnStatus.addItem("Return");
		comboReturnStatus.addItem("not return");
		
		txtTransactionID = new JTextField();
		txtTransactionID.setBounds(124, 39, 127, 23);
		panel.add(txtTransactionID);
		txtTransactionID.setColumns(10);
		
		txtAdvancePay = new JTextField();
		txtAdvancePay.setColumns(10);
		txtAdvancePay.setBounds(124, 210, 127, 28);
		panel.add(txtAdvancePay);
		
		txtTotAmnt = new JTextField();
		txtTotAmnt.setColumns(10);
		txtTotAmnt.setBounds(124, 289, 127, 28);
		panel.add(txtTotAmnt);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(124, 73, 127, 42);
		panel.add(dateChooser1);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setDateFormatString("yyyy-MM-dd");
		dateChooser2.setBounds(124, 126, 127, 35);
		panel.add(dateChooser2);
	
		
		JButton BttnADD = new JButton("ADD");
		//Action for ADD button
		BttnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Add action listnerr");
				add(dateChooser1,dateChooser2);
				txtTransactionID.setText("");
				dateChooser1.setDate(null);
				dateChooser2.setDate(null);
				comboReturnStatus.setSelectedItem("");
				txtAdvancePay.setText("");
				txtDueAmnt.setText("");
				txtTotAmnt.setText("");
				autoid();
				table_update();				
			}
		});
		
		BttnADD.setBounds(11, 342, 110, 23);
		panel.add(BttnADD);
		
		JButton bttnEDIT = new JButton("EDIT");
		bttnEDIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(dateChooser1, dateChooser2);
				txtTransactionID.setText("");
				dateChooser1.setDate(null);
				dateChooser2.setDate(null);
				comboReturnStatus.setSelectedItem("");
				txtAdvancePay.setText("");
				txtDueAmnt.setText("");
				txtTotAmnt.setText("");
				autoid();
				table_update();
			}
		});
		bttnEDIT.setBounds(141, 342, 110, 22);
		panel.add(bttnEDIT);
		
		JButton bttnDELETE = new JButton("DELETE");
		bttnDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				txtTransactionID.setText("");
				dateChooser1.setDate(null);
				dateChooser2.setDate(null);
				comboReturnStatus.setSelectedItem("");
				txtAdvancePay.setText("");
				txtDueAmnt.setText("");
				txtTotAmnt.setText("");
				autoid();
				
			}
		});
		bttnDELETE.setBounds(10, 374, 110, 24);
		panel.add(bttnDELETE);
		
		JButton bbtnRESET = new JButton("RESET");
		bbtnRESET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTransactionID.setText("");
				dateChooser1.setDate(null);
				dateChooser2.setDate(null);
				comboReturnStatus.setSelectedItem("");
				txtAdvancePay.setText("");
				txtDueAmnt.setText("");
				txtTotAmnt.setText("");
				autoid();
			}
		});
		bbtnRESET.setBounds(141, 373, 110, 26);
		panel.add(bbtnRESET);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 11, 604, 354);
		panel.add(scrollPane);
		
		table = new JTable();
		//Jtable Edit Function
		table.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("table Action Click");
				DefaultTableModel d1 = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				txtTransactionID.setText(d1.getValueAt(selectIndex, 0).toString());
				comboReturnStatus.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());
				txtAdvancePay.setText(d1.getValueAt(selectIndex, 4).toString());
				txtDueAmnt.setText(d1.getValueAt(selectIndex, 5).toString());
				txtTotAmnt.setText(d1.getValueAt(selectIndex, 6).toString());
				String String_Start = d1.getValueAt(selectIndex, 1).toString();
				String String_End = d1.getValueAt(selectIndex, 2).toString();
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
		}
);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"transactionID", "rentalStartDate", "rentalEndDate", "returnStatus", "advancePaid", "dueAmount", "totalAmount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		txtDueAmnt = new JTextField();
		txtDueAmnt.setColumns(10);
		txtDueAmnt.setBounds(124, 249, 127, 25);
		panel.add(txtDueAmnt);
		
		JButton Bttnreturn = new JButton("Return");
		Bttnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IT_Main_GUI it = new IT_Main_GUI();
				it.setVisible(true);
			}
		});
		Bttnreturn.setBounds(754, 372, 111, 28);
		panel.add(Bttnreturn);
		
		
		
		autoid();
		table_update();
	}
	public void add(JDateChooser dateChooser1,JDateChooser dateChooser2) {
		String TID= txtTransactionID.getText();
		
		SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
		String Startdate = Date_Format.format(dateChooser1.getDate());
		String Enddate= Date_Format.format(dateChooser2.getDate());
		
		Double TotalAmount =  Double.parseDouble(txtTotAmnt.getText());
		Double advancePaid=  Double.parseDouble(txtAdvancePay.getText());
		Double  dueAmount = Double.parseDouble(txtDueAmnt.getText());
		String returnStatus = comboReturnStatus.getSelectedItem().toString();
		
		Transaction_Controller trans = new Transaction_Controller(TID,Startdate,Enddate,TotalAmount,advancePaid,dueAmount,returnStatus);
		trans.create();//adding to the customer database
		
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);
		comboReturnStatus.setSelectedItem(-1);
		txtTotAmnt.setText("");
		txtAdvancePay.setText("");
		txtDueAmnt.setText("");
	}
	
	public void delete() {
		System.out.println("delete");
		String TID = txtTransactionID.getText().toString();
		System.out.println("TID   " + TID);
			
		Transaction_Controller trans_Delete = new Transaction_Controller(TID);
		trans_Delete.remove(TID);
		
		System.out.println("finish update");
		table_update();
	}
	public void edit(JDateChooser dateChooser1,JDateChooser dateChooser2) {
		System.out.println("in Edit");
		DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
		
		int selectedIndex = table.getSelectedRow();
		String TID= dmodel.getValueAt(selectedIndex, 0).toString();
		SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
		String Startdate = Date_Format.format(dateChooser1.getDate());
		String Enddate= Date_Format.format(dateChooser2.getDate());
		Double advancePaid= Double.parseDouble(txtAdvancePay.getText().toString());
		Double  dueAmount  = Double.parseDouble(txtDueAmnt.getText().toString());
		Double TotalAmount= Double.parseDouble(txtTotAmnt.getText().toString());
		String returnStatus = comboReturnStatus.getSelectedItem().toString();
	
		
		Transaction_Controller trans = new Transaction_Controller(TID,Startdate,Enddate,TotalAmount,advancePaid,dueAmount,returnStatus);
		trans.update();;//adding to the customer database
	}
	
	
}
