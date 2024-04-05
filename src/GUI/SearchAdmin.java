package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.AdminController;

import Model.MydbConnection;

public class SearchAdmin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchAdmin frame = new SearchAdmin();
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
	public SearchAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 11, 786, 450);
		contentPane.add(contentPane_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(125, 81, 340, 34);
		contentPane_1.add(comboBox);
		try {
			ResultSet resultSet;
			Connection con = MydbConnection.getConnection();
			
			PreparedStatement pst = con.prepareStatement("SELECT adminID FROM admins");
			resultSet = pst.executeQuery();
			
			 // Retrieve customer IDs from the database and add them to the comboBox
	        while (resultSet.next()) {
	            comboBox.addItem(resultSet.getString("adminID"));
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				AdminController cont = new AdminController(comboBox.getSelectedItem().toString());
				Vector<Vector<Object>> data = cont.Read(); 
				System.out.println(data);
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				
				for (Vector<Object> rowData : data) {
				    model1.addRow(rowData);
				}
			}
		});
		Search.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Search.setBounds(525, 80, 109, 34);
		contentPane_1.add(Search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 154, 613, 125);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"adminID", "adminName", "adminUsername", "adminPassword"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				 if (selectedIndex == -1) {
			            // No row is selected, handle this case appropriately
			            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
			            return;
			        }
				String adminID= dmodel.getValueAt(selectedIndex, 0).toString();
				
				int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION) {
					
					AdminController cont = new AdminController(adminID);
					cont.Delete();
					
					JOptionPane.showMessageDialog(null,"Record deleted.");
					 
					 table_update();
				}
			}

			
		});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Delete.setBounds(64, 370, 103, 34);
		contentPane_1.add(Delete);
		
		JButton Return = new JButton("Return");
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFrame ad = new AdminFrame();
				ad.setVisible(true);
			}
		});
		Return.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Return.setBounds(615, 370, 103, 34);
		contentPane_1.add(Return);
		
		JLabel lblAdminSearch = new JLabel("Admin Search");
		lblAdminSearch.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblAdminSearch.setBounds(284, 11, 232, 49);
		contentPane_1.add(lblAdminSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
			     model.setRowCount(0);
			     table_update();
			}
		});
		btnReset.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnReset.setBounds(346, 370, 103, 34);
		contentPane_1.add(btnReset);
	}
	
	private void table_update() {
		// TODO Auto-generated method stub
	Connection con = MydbConnection.getConnection();
		
		try {
			// Prepare a SQL query
			PreparedStatement pt = con.prepareStatement("SELECT * FROM admins");

            // Execute the query
            ResultSet rs = pt.executeQuery();

            // Get the ResultSetMetaData to retrieve column information
            ResultSetMetaData rd = rs.getMetaData();

            // Get the column count
            int columnCount = rd.getColumnCount();
            
         // Create a DefaultTableModel for the JTable
      
            DefaultTableModel df = (DefaultTableModel) table.getModel();

            // Clear the existing rows in the table
            df.setRowCount(0);
            

                
             // Create a List to hold the row data
   	         List<Object> rowData = new ArrayList<>();
   	
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
