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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Controll.EmployeeController;
import Model.Database;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmpId;
	private JTextField textEmpName;
	private JTextField textEmpRole;
	private JTextField textEmpSal;
	private JTextField textEmpUsern;
	private JTextField textEmpPass;
	private JTable tableE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame frame = new EmployeeFrame();
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
	public EmployeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 1050, 529);
		contentPane.add(contentPane_1);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane_1_1.setBackground(Color.WHITE);
		contentPane_1_1.setBounds(0, 0, 1052, 643);
		contentPane_1.add(contentPane_1_1);
		contentPane_1_1.setLayout(null);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(31, 26, 123, 38);
		lblEmployee.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		contentPane_1_1.add(lblEmployee);
		
		textEmpId = new JTextField();
		textEmpId.setBounds(145, 89, 193, 33);
		textEmpId.setColumns(10);
		textEmpId.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpId);
		
		textEmpName = new JTextField();
		textEmpName.setBounds(145, 133, 193, 33);
		textEmpName.setColumns(10);
		textEmpName.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpName);
		
		textEmpRole = new JTextField();
		textEmpRole.setBounds(145, 177, 193, 33);
		textEmpRole.setColumns(10);
		textEmpRole.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpRole);
		
		JLabel lblEmployeeId = new JLabel("Employee Id :");
		lblEmployeeId.setBounds(35, 92, 91, 24);
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEmployeeId.setBackground(new Color(211, 211, 211));
		contentPane_1_1.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(35, 134, 91, 24);
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblName.setBackground(new Color(211, 211, 211));
		contentPane_1_1.add(lblName);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setBounds(35, 178, 91, 24);
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblRole.setBackground(new Color(211, 211, 211));
		contentPane_1_1.add(lblRole);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 91, 633, 216);
		contentPane_1_1.add(scrollPane);
		
		tableE = new JTable();
		tableE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				DefaultTableModel model = (DefaultTableModel) tableE.getModel();
				
				int selectedIndex = tableE.getSelectedRow();
				
				textEmpId.setText(model.getValueAt(selectedIndex, 0).toString());
				textEmpName.setText(model.getValueAt(selectedIndex, 1).toString());
				textEmpRole.setText(model.getValueAt(selectedIndex, 2).toString());
				textEmpSal.setText(model.getValueAt(selectedIndex, 3).toString());
				textEmpUsern.setText(model.getValueAt(selectedIndex,4).toString());
				textEmpPass.setText(model.getValueAt(selectedIndex, 5).toString());
				
				
				
			}
		});
		tableE.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Name", "Role", "Salary", "Username", "Password"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableE.getColumnModel().getColumn(1).setPreferredWidth(96);
		tableE.getColumnModel().getColumn(2).setPreferredWidth(99);
		scrollPane.setViewportView(tableE);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginStage3 l = new loginStage3();
				l.setVisible(true);
			}
		});
		btnNewButton.setBounds(937, 44, 89, 35);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(btnNewButton);
		
		JButton Delete = new JButton("Delete");
		Delete.setBounds(31, 434, 91, 33);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dmodel = (DefaultTableModel) tableE.getModel();
				
				int selectedIndex = tableE.getSelectedRow();
				
				String Empid= dmodel.getValueAt(selectedIndex, 0).toString();
				
				int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION) {
					
					EmployeeController cont = new EmployeeController(Empid);
					cont.Delete();
					
					JOptionPane.showMessageDialog(null,"Record deleted.");
					
					 textEmpName.setText("");
					 textEmpRole.setText("");
					 textEmpSal.setText("");
					 textEmpUsern.setText("");
					 textEmpPass.setText("");
					 
					 autoid();
					 
					 table_update();
				}
				
			}
		});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contentPane_1_1.add(Delete);
		
		JButton add = new JButton("Add");
		add.setBounds(31, 377, 91, 33);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EmployeeController cont1 = new EmployeeController();
				
				cont1.setEmployeeId(textEmpId.getText());
				cont1.setName(textEmpName.getText());
				cont1.setRole(textEmpRole.getText());
				String empSalT =  textEmpSal.getText();
				try {
				    double empSalD = Double.parseDouble(empSalT);
				    cont1.setSalary(empSalD);
				} catch (NumberFormatException e1) {
				    // Handle the case where the input is not a valid double, e.g., show an error message.
				}
				cont1.setUsername(textEmpUsern.getText());
				cont1.setPassword(textEmpPass.getText());
				
				
				
				cont1.Create();
				
				 JOptionPane.showMessageDialog(null,"Record Was Added Successfully!");
				 
				 textEmpName.setText("");
				 textEmpRole.setText("");
				 textEmpSal.setText("");
				 textEmpUsern.setText("");
				 textEmpPass.setText("");
				 
				 autoid();
				 table_update();
				

				
			}
		});
		add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contentPane_1_1.add(add);
		
		JButton edit = new JButton("Edit");
		edit.setBounds(251, 377, 91, 33);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dmodel = (DefaultTableModel) tableE.getModel();
				
				int selectedIndex = tableE.getSelectedRow();
				
				EmployeeController cont = new EmployeeController();
				
				cont.setEmployeeId( dmodel.getValueAt(selectedIndex, 0).toString());
				cont.setName(textEmpName.getText());
				cont.setRole(textEmpRole.getText());
				String empSalT =  textEmpSal.getText();
				try {
				    double empSalD = Double.parseDouble(empSalT);
				    cont.setSalary(empSalD);
				} catch (NumberFormatException e1) {
				    // Handle the case where the input is not a valid double, e.g., show an error message.
				}
				cont.setUsername(textEmpUsern.getText());
				cont.setPassword(textEmpPass.getText());
				
				
				
				cont.Update();
				
				 JOptionPane.showMessageDialog(null,"Record Updated Successfully!");
				 
				 textEmpName.setText("");
				 textEmpRole.setText("");
				 textEmpSal.setText("");
				 textEmpUsern.setText("");
				 textEmpPass.setText("");
				 
				 autoid();
				 table_update();
				
			}
		});
		edit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contentPane_1_1.add(edit);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.setBounds(247, 434, 91, 33);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					textEmpId.setText("");
					 textEmpName.setText("");
					 textEmpRole.setText("");
					 textEmpSal.setText("");
					 textEmpUsern.setText("");
					 textEmpPass.setText("");
					 
					
				}
			
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contentPane_1_1.add(btnCancel);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(35, 224, 91, 24);
		lblSalary.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		contentPane_1_1.add(lblSalary);
		
		textEmpSal = new JTextField();
		textEmpSal.setBounds(145, 221, 193, 33);
		textEmpSal.setColumns(10);
		textEmpSal.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpSal);
		
		JLabel lblNicl = new JLabel("Username :");
		lblNicl.setBounds(35, 271, 91, 24);
		lblNicl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		contentPane_1_1.add(lblNicl);
		
		textEmpUsern = new JTextField();
		textEmpUsern.setBounds(145, 268, 193, 33);
		textEmpUsern.setColumns(10);
		textEmpUsern.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpUsern);
		
		JLabel lblLicl = new JLabel("Password :");
		lblLicl.setBounds(35, 316, 91, 24);
		lblLicl.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		contentPane_1_1.add(lblLicl);
		
		textEmpPass = new JTextField();
		textEmpPass.setBounds(145, 313, 193, 33);
		textEmpPass.setColumns(10);
		textEmpPass.setBackground(new Color(230, 230, 250));
		contentPane_1_1.add(textEmpPass);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeSearchFrame emp = new EmployeeSearchFrame();
				emp.setVisible(true);
			}
		});
		btnSearch.setBounds(937, 434, 91, 33);
		btnSearch.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		contentPane_1_1.add(btnSearch);
		
		table_update();
		autoid();
	}
	
	public void table_update() {
		// TODO Auto-generated method stub
		Database db1 = new Database();
		
		try {
			// Prepare a SQL query
			PreparedStatement pst = db1.getConnection().prepareStatement("SELECT * FROM employee");

            // Execute the query
            ResultSet rs = pst.executeQuery();

            // Get the ResultSetMetaData to retrieve column information
            ResultSetMetaData rd = rs.getMetaData();

            // Get the column count
            int columnCount = rd.getColumnCount();
            
         // Create a DefaultTableModel for the JTable
            DefaultTableModel df = (DefaultTableModel) tableE.getModel();

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
		

	public void autoid() {
		
		Database db = new Database();
		// TODO Auto-generated method stub
		Statement s;
		try {
			s = db.getConnection().createStatement();
			// Execute the SQL query to find the maximum value of "employeeID"
	        ResultSet rs = s.executeQuery("SELECT Max(employeeID) FROM employee");
	        rs.next();
	        String max =rs.getString("Max(employeeID)");
	        
	        if(max==null) {
            	textEmpId.setText("E0001");
            }else {
            	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
                String numericPart = max.substring(1);

                // Parse the numeric portion as a long
                long id = Long.parseLong(numericPart);

                // Increment the ID to get the next value
                id ++;
                
                textEmpId.setText("E"+ String.format("%04d",id));
            }

	  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
}
}
