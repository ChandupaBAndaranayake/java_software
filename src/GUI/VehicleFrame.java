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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.Vehicle_Controller;
import Model.Database;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class VehicleFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textVehicleID;
	private JTextField textVehicleType;
	private JTextField txtDailyRate;
	private JTable table;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBoxtype;
	private JComboBox<String> comboAvailable;
	//String dailyRateText = txtDailyRate.getText();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleFrame frame = new VehicleFrame();
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
	public VehicleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 1052, 643);
		contentPane.add(contentPane_1);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lblVehicle.setBounds(31, 26, 123, 38);
		contentPane_1.add(lblVehicle);
		
		textVehicleID = new JTextField();
		textVehicleID.setColumns(10);
		textVehicleID.setBackground(new Color(230, 230, 250));
		textVehicleID.setBounds(145, 89, 193, 33);
		contentPane_1.add(textVehicleID);
		
		textVehicleType = new JTextField();
		textVehicleType.setColumns(10);
		textVehicleType.setBackground(new Color(230, 230, 250));
		textVehicleType.setBounds(145, 177, 193, 33);
		contentPane_1.add(textVehicleType);
		
		JLabel lblVehicleId = new JLabel("Vehicle Id ");
		lblVehicleId.setForeground(new Color(0, 0, 0));
		lblVehicleId.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblVehicleId.setBackground(new Color(211, 211, 211));
		lblVehicleId.setBounds(35, 92, 91, 24);
		contentPane_1.add(lblVehicleId);
		
		JLabel lblVehicleType = new JLabel("Type");
		lblVehicleType.setForeground(new Color(0, 0, 0));
		lblVehicleType.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblVehicleType.setBackground(Color.DARK_GRAY);
		lblVehicleType.setBounds(35, 134, 91, 24);
		contentPane_1.add(lblVehicleType);
		
		JLabel lblModel = new JLabel(" Brand ");
		lblModel.setForeground(new Color(0, 0, 0));
		lblModel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblModel.setBackground(new Color(211, 211, 211));
		lblModel.setBounds(31, 178, 91, 24);
		contentPane_1.add(lblModel);
		
		JLabel lblFuelType = new JLabel("Fuel Type");
		lblFuelType.setForeground(new Color(0, 0, 0));
		lblFuelType.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuelType.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblFuelType.setBounds(35, 229, 91, 24);
		contentPane_1.add(lblFuelType);
		
		JLabel lblAvaila = new JLabel("Available");
		lblAvaila.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblAvaila.setBounds(35, 341, 91, 24);
		contentPane_1.add(lblAvaila);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(145, 225, 193, 38);
		contentPane_1.add(comboBox);
		comboBox.addItem("Petrol");
		comboBox.addItem("Diesel");
		comboBox.addItem("Battery");

		
		comboBoxtype = new JComboBox<String>();
		comboBoxtype.setBounds(145, 130, 193, 36);
		//comboBoxmodel.setModel(new DefaultComboBoxModel(new String[] {"Micro", "Sedan", "Hatchback", "Universal", "Liftback", "Coupe", "Sport car", "Super car", "Van", "Minibus", "Pickup", "Minivan"}));
		contentPane_1.add(comboBoxtype);
		comboBoxtype.addItem("Micro");
		comboBoxtype.addItem("Sedan");
		comboBoxtype.addItem("Hatchback");
		comboBoxtype.addItem("Universal");
		comboBoxtype.addItem("Liftback");
		comboBoxtype.addItem("Coupe");
		comboBoxtype.addItem("Sport car");
		comboBoxtype.addItem("Super car");
		comboBoxtype.addItem("Van");
		comboBoxtype.addItem("Minibus");
		comboBoxtype.addItem("Pickup");
		comboBoxtype.addItem("Minivan");
		
		comboAvailable = new JComboBox<>();
		comboAvailable.setBounds(145, 337, 193, 38);
		contentPane_1.add(comboAvailable);
		comboAvailable.addItem("yes");
		comboAvailable.addItem("no");
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add();
				textVehicleType.setText("");
				txtDailyRate.setText("");
				comboBox.setSelectedIndex(-1);
				comboBoxtype.setSelectedIndex(-1);
				comboAvailable.setSelectedIndex(-1);
				textVehicleID.setText("");		
				autoid();
			}
		});
		add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		add.setBounds(31, 396, 91, 33);
		contentPane_1.add(add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(348, 91, 515, 338);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int selectedIndex = table.getSelectedRow();
				
				textVehicleID.setText(model.getValueAt(selectedIndex, 0).toString());
				textVehicleType.setText(model.getValueAt(selectedIndex, 1).toString());
				comboBoxtype.setSelectedItem(model.getValueAt(selectedIndex, 2).toString());
				txtDailyRate.setText(model.getValueAt(selectedIndex, 3).toString());
				comboBox.setSelectedItem(model.getValueAt(selectedIndex, 4).toString());
				comboAvailable.setSelectedItem(model.getValueAt(selectedIndex, 5).toString());
				
			    				
				
				
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setColumnHeaderView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Vehicle ID", "Type", "Model", "Daily Rate", "Fuel Type", "Available"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Double.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		
		scrollPane.setViewportView(table);
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edit();
				textVehicleType.setText("");
				txtDailyRate.setText("");
				comboBox.setSelectedIndex(-1);
				comboBoxtype.setSelectedIndex(-1);
				comboAvailable.setSelectedIndex(-1);
				textVehicleID.setText("");
				autoid();
			}
		});
		edit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		edit.setBounds(231, 396, 91, 33);
		contentPane_1.add(edit);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				textVehicleType.setText("");
				txtDailyRate.setText("");
				textVehicleID.setText("");
				comboBox.setSelectedIndex(-1);
				comboBoxtype.setSelectedIndex(-1);
				autoid();
				table_update();
			}
			});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Delete.setBounds(31, 440, 91, 33);
		contentPane_1.add(Delete);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textVehicleType.setText("");
				txtDailyRate.setText("");
				textVehicleID.setText("");
				comboBox.setSelectedIndex(-1);
				comboBoxtype.setSelectedIndex(-1);
				autoid();
			}
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnCancel.setBounds(231, 440, 91, 33);
		contentPane_1.add(btnCancel);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(896, 40, 89, 23);
		contentPane_1.add(btnNewButton);
		
		JLabel lblDailyRate = new JLabel("Daily Rate");
		lblDailyRate.setForeground(new Color(0, 0, 0));
		lblDailyRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDailyRate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblDailyRate.setBounds(35, 285, 91, 24);
		contentPane_1.add(lblDailyRate);
		
		txtDailyRate = new JTextField();
		txtDailyRate.setColumns(10);
		txtDailyRate.setBackground(new Color(230, 230, 250));
		txtDailyRate.setBounds(145, 284, 193, 33);
		contentPane_1.add(txtDailyRate);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IT_Main_GUI it = new IT_Main_GUI();
				it.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnReturn.setBounds(772, 31, 91, 33);
		contentPane_1.add(btnReturn);
	
		
		autoid();
		table_update();
	}
	
	public void table_update() {
		DefaultTableModel df = (DefaultTableModel) table.getModel();
        // Clear the existing rows in the table
        df.setRowCount(0);
        
        Vehicle_Controller vehic = new Vehicle_Controller();
        Vector<Vector<Object>> data = vehic.Read();
        
        for(Vector<Object> rowData: data) {
        	System.out.println(rowData);
        	df.addRow(rowData);
        } 
	}
	public void autoid() {
		Vehicle_Controller vehi = new Vehicle_Controller();
		String max = vehi.MaxvehicleID();
		if(max==null) {
        	textVehicleID.setText("V0001");
        }else {
        	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
            String numericPart = max.substring(1);

            // Parse the numeric portion as a long
            long id = Long.parseLong(numericPart);

            // Increment the ID to get the next value
            id ++;
            
            textVehicleID.setText("V"+ String.format("%04d",id));
        }
	}
	public void add() {
		String vehiid= textVehicleID.getText();
		String type= comboBoxtype.getSelectedItem().toString();
		String model= textVehicleType.getText();
		String fuelType= comboBox.getSelectedItem().toString();
		double value = Double.parseDouble(txtDailyRate.getText().toString());
		String available = comboAvailable.getSelectedItem().toString();
		 
		Vehicle_Controller vehic = new Vehicle_Controller(vehiid,type,model,value,fuelType,available);
		vehic.create();//adding to the customer database
		
		
		textVehicleType.setText("");
		txtDailyRate.setText("");
		comboBox.setSelectedIndex(-1);
		comboBoxtype.setSelectedIndex(-1);
		comboAvailable.setSelectedIndex(-1);
		
		 table_update();
	}
	public void delete() {
		
		DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
		
		int selectedIndex = table.getSelectedRow();
		
		String VID= dmodel.getValueAt(selectedIndex, 0).toString();
	
		int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			System.out.println("Alo");
			Vehicle_Controller vehic = new Vehicle_Controller(VID);
			vehic.remove();
		}
	}
	public void edit() {
		DefaultTableModel dmodel = (DefaultTableModel) table.getModel();
		
		int selectedIndex = table.getSelectedRow();
		String VID= dmodel.getValueAt(selectedIndex, 0).toString();
		String type= comboBoxtype.getSelectedItem().toString();
		String model= textVehicleType.getText();
		String fuelType= comboBox.getSelectedItem().toString();
		double value= Double.parseDouble(txtDailyRate.getText().toString());
		String available = comboAvailable.getSelectedItem().toString();
		
		Vehicle_Controller vehic = new Vehicle_Controller(VID,type,model,value,fuelType,available);
		vehic.update();
		
		table_update();
	}
}
