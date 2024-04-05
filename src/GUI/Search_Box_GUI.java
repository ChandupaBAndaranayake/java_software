package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.AdminController;
import Controll.Transaction_Controller;
import Model.MydbConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search_Box_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Box_GUI frame = new Search_Box_GUI();
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
	public Search_Box_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 115, 650, 147);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				table.editCellAt(table.getSelectedRow(), 0);
				table.editCellAt(table.getSelectedRow(), 1);
				table.editCellAt(table.getSelectedRow(), 2);
				table.editCellAt(table.getSelectedRow(), 3);
				table.editCellAt(table.getSelectedRow(), 4);
				table.editCellAt(table.getSelectedRow(), 6);
				
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Transaction ID", "Start Date", "End Date", "Return Status", "Advanced Paid", "Amount Due", "Total Amount"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(94);
		table.getColumnModel().getColumn(6).setPreferredWidth(94);
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		comboBox.setBounds(48, 32, 263, 33);
		contentPane.add(comboBox);
		    
		try {
			ResultSet resultSet;
			Connection con = MydbConnection.getConnection();
			
			PreparedStatement pst = con.prepareStatement("SELECT transactionID FROM transaction");
			resultSet = pst.executeQuery();
			
			 // Retrieve customer IDs from the database and add them to the comboBox
	        while (resultSet.next()) {
	            comboBox.addItem(resultSet.getString("transactionID"));
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String TID = comboBox.getSelectedItem().toString();
				//System.out.println("T_ID " + TID);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
				Transaction_Controller cont = new Transaction_Controller(TID,null,null);
				
				Vector<Vector<Object>> data = cont.Read_transaction();
				System.out.println(data);

				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				for (Vector<Object> rowData : data) {
					 model1.addRow(rowData);
				   
				}
				
				 // Remove the corresponding row from the JTable
				
			}
		});
		Search.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Search.setBounds(395, 31, 91, 33);
		contentPane.add(Search);
		
		JButton btnEdit = new JButton("Return");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				loginStage3 l = new loginStage3();
				l.setVisible(true);
				
			}
		});
		btnEdit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnEdit.setBounds(590, 309, 91, 33);
		contentPane.add(btnEdit);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				table_update();
				
			}
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnCancel.setBounds(564, 31, 91, 33);
		contentPane.add(btnCancel);
		
		table_update();
	}
	
	public void table_update() {
		// TODO Auto-generated method stub
		Connection con = MydbConnection.getConnection();
		try {
			// Prepare a SQL query
			PreparedStatement pst = con.prepareStatement("SELECT * FROM transaction");

            // Execute the query
            ResultSet rs = pst.executeQuery();

            // Get the ResultSetMetaData to retrieve column information
            ResultSetMetaData rd = rs.getMetaData();

            // Get the column count
            int columnCount = rd.getColumnCount();
            
         // Create a DefaultTableModel for the JTable
            DefaultTableModel df = (DefaultTableModel) table.getModel();

            // Clear the existing rows in the table
            df.setRowCount(0);
            

                
             // Create a List to hold the row data
   	         Vector<Object> rowData = new Vector<>();
   	
   	         while (rs.next()) {
   	             // Clear the List for each new row
   	             rowData.clear();
   	
   	             // Loop through the columns and add data to the row
   	             for (int i = 1; i <= columnCount; i++) {
   	                 rowData.add(rs.getString(i));
   	             }
   	
   	             // Add the row data to the table model
   	             df.addRow(rowData.toArray()); // Convert List to an array before adding
   	         }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}


}
