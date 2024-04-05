package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.AdminController;
import Model.MydbConnection;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AdmintextField;
	private JTextField NametextField;
	private JTextField UsernametextField;
	private JTextField PasswordtextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 945, 454);
		contentPane.add(contentPane_1);
		
		JLabel lblAdmin = new JLabel("Administrator ");
		lblAdmin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lblAdmin.setBounds(31, 11, 193, 38);
		contentPane_1.add(lblAdmin);
		
		AdmintextField = new JTextField();
		AdmintextField.setColumns(10);
		AdmintextField.setBackground(new Color(230, 230, 250));
		AdmintextField.setBounds(145, 75, 193, 33);
		contentPane_1.add(AdmintextField);
		
		JTextField NametextField = new JTextField();
		NametextField.setColumns(10);
		NametextField.setBackground(new Color(230, 230, 250));
		NametextField.setBounds(145, 131, 193, 33);
		contentPane_1.add(NametextField);
		
		UsernametextField = new JTextField();
		UsernametextField.setColumns(10);
		UsernametextField.setBackground(new Color(230, 230, 250));
		UsernametextField.setBounds(145, 189, 193, 33);
		contentPane_1.add(UsernametextField);
		
		JLabel lblAdminid = new JLabel("AdminID");
		lblAdminid.setForeground(Color.BLACK);
		lblAdminid.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblAdminid.setBackground(new Color(211, 211, 211));
		lblAdminid.setBounds(31, 76, 91, 24);
		contentPane_1.add(lblAdminid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblName.setBackground(Color.DARK_GRAY);
		lblName.setBounds(31, 132, 91, 24);
		contentPane_1.add(lblName);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setForeground(Color.BLACK);
		lblUser.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblUser.setBackground(new Color(211, 211, 211));
		lblUser.setBounds(31, 190, 91, 24);
		contentPane_1.add(lblUser);
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminController adm = new AdminController();
				
				adm.setAdminId(AdmintextField.getText());
				adm.setName(NametextField.getText());
				adm.setusername(UsernametextField.getText());
				adm.setPassword(PasswordtextField.getText());
				
				adm.Create();
				
				 JOptionPane.showMessageDialog(null,"Record Was Added Successfully!");
				 
				 
				 AdmintextField.setText("");
				 NametextField.setText("");
				 UsernametextField.setText("");
				 PasswordtextField.setText("");
				
				 
				 autoid();
				 table_update();
				
			}

			
		});
		Add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Add.setBounds(31, 335, 91, 33);
		contentPane_1.add(Add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(364, 75, 515, 313);
		contentPane_1.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				AdmintextField.setText(model.getValueAt(selectedIndex, 0).toString());
				NametextField.setText(model.getValueAt(selectedIndex, 1).toString());
				UsernametextField.setText(model.getValueAt(selectedIndex, 2).toString());
				PasswordtextField.setText(model.getValueAt(selectedIndex, 3).toString());
				
			}
		});
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
			/**
			 * 
			 */
			private static final long serialVersionUID1 = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
     	});
		scrollPane_1.setViewportView(table);
		
		JButton Edit = new JButton("Edit");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				AdminController adm2 = new AdminController();
				
				adm2.setAdminId( dmodel.getValueAt(selectedIndex, 0).toString());
				adm2.setName( NametextField.getText());
				adm2.setusername( UsernametextField.getText());
				adm2.setPassword(PasswordtextField.getText());
				
				adm2.Update();
				
				 JOptionPane.showMessageDialog(null,"Record Updated Successfully!");
				 
				 table_update();
			}
		});
		Edit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Edit.setBounds(220, 335, 91, 33);
		contentPane_1.add(Edit);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				String Adminid= dmodel.getValueAt(selectedIndex, 0).toString();
				
				int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION) {
					
					AdminController cont = new AdminController(Adminid);
					cont.Delete();
					
					JOptionPane.showMessageDialog(null,"Record deleted.");
					 
					 table_update();
				}
			}
		});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Delete.setBounds(31, 392, 91, 33);
		contentPane_1.add(Delete);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmintextField.setText("");
				NametextField.setText("");
				UsernametextField.setText("");
				PasswordtextField.setText("");
				 
			}
		});
		Reset.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Reset.setBounds(220, 392, 91, 33);
		contentPane_1.add(Reset);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblPassword.setBounds(31, 257, 91, 24);
		contentPane_1.add(lblPassword);
		
		PasswordtextField = new JTextField();
		PasswordtextField.setColumns(10);
		PasswordtextField.setBackground(new Color(230, 230, 250));
		PasswordtextField.setBounds(145, 256, 193, 33);
		contentPane_1.add(PasswordtextField);
		
		JButton btnCancel_1 = new JButton("Return");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginStage3 l = new loginStage3();
				l.setVisible(true);
			}
		});
		btnCancel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnCancel_1.setBounds(788, 30, 91, 31);
		contentPane_1.add(btnCancel_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnSearch.setBounds(788, 399, 91, 33);
		contentPane_1.add(btnSearch);
		
		autoid();
		table_update();
	}
	
	
	private void table_update() {
		// TODO Auto-generated method stub
		//we encountered an error called ConcurrentModificationException , and we dont no how
		//recovere form , we implemented a Vector<Vector<Object>> which was modifing by multiple
		//threads at the same time
		//that is why we did the connnection in this frame
		
				Connection con = MydbConnection.getConnection();
				
				try {
					// Prepare a SQL query
					PreparedStatement pst = con.prepareStatement("SELECT * FROM admins");

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

	private void autoid() {
		AdminController admi = new AdminController();
		String max = admi.MaxcusID();
		if(max==null) {
			AdmintextField.setText("A0001");
        }else {
        	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
            String numericPart = max.substring(1);

            // Parse the numeric portion as a long
            long id = Long.parseLong(numericPart);

            // Increment the ID to get the next value
            id ++;
            System.out.println(id);
            AdmintextField.setText("A"+ String.format("%04d",id));
        }
            

	
	}
	
}
