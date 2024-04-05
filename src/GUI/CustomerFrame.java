package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controll.CustomerController;
import Model.MydbConnection;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;



public class CustomerFrame extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCusid;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtPnum;
	private JTextField txtEmail;
	private JTable tableC;
	private JTextField txtnic;
	private JTextField txtlic;
	private static Connection con = MydbConnection.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(143, 188, 143));
	
		setTitle("Customer\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 682);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBIGCUS = new JLabel("Customer");
		lblBIGCUS.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 25));
		lblBIGCUS.setBounds(10, 28, 151, 24);
		contentPane.add(lblBIGCUS);
		
		txtCusid = new JTextField();
		txtCusid.setBackground(new Color(230, 230, 250));
		txtCusid.setBounds(188, 88, 193, 33);
		contentPane.add(txtCusid);
		txtCusid.setColumns(10);
		
		txtFname = new JTextField();
		txtFname.setBackground(new Color(230, 230, 250));
		txtFname.setBounds(188, 133, 193, 33);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBackground(new Color(230, 230, 250));
		txtLname.setColumns(10);
		txtLname.setBounds(188, 177, 193, 33);
		contentPane.add(txtLname);
		
		txtPnum = new JTextField();
		txtPnum.setBackground(new Color(230, 230, 250));
		txtPnum.setColumns(10);
		txtPnum.setBounds(188, 226, 193, 33);
		contentPane.add(txtPnum);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(230, 230, 250));
		txtEmail.setColumns(10);
		txtEmail.setBounds(188, 272, 193, 33);
		contentPane.add(txtEmail);

		txtnic = new JTextField();
		txtnic.setColumns(10);
		txtnic.setBackground(new Color(230, 230, 250));
		txtnic.setBounds(188, 317, 193, 33);
		contentPane.add(txtnic);
		
		txtlic = new JTextField();
		txtlic.setColumns(10);
		txtlic.setBackground(new Color(230, 230, 250));
		txtlic.setBounds(188, 361, 193, 33);
		contentPane.add(txtlic);
		
		JLabel lblCUSID = new JLabel("Customer ID   :");
		lblCUSID.setHorizontalAlignment(SwingConstants.LEFT);
		lblCUSID.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblCUSID.setBounds(31, 89, 140, 24);
		contentPane.add(lblCUSID);
		
		JLabel lblFirstName = new JLabel("First Name     :");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblFirstName.setBounds(31, 134, 140, 24);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name     :");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblLastName.setBounds(31, 178, 140, 24);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number    :");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblPhoneNumber.setBounds(31, 227, 140, 24);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email            :");
		lblEmail.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblEmail.setBounds(31, 273, 91, 24);
		contentPane.add(lblEmail);
		
		JLabel lblnic = new JLabel("NIC               :");
		lblnic.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblnic.setBounds(31, 320, 104, 21);
		contentPane.add(lblnic);
		
		JLabel lbllic = new JLabel("LIC                 :");
		lbllic.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lbllic.setBounds(30, 364, 96, 21);
		contentPane.add(lbllic);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		add.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		add.setBounds(31, 428, 140, 51);
		contentPane.add(add);
		
		tableC = new JTable();
		tableC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) tableC.getModel();
				
				int selectedIndex = tableC.getSelectedRow();
				
				txtCusid.setText(model.getValueAt(selectedIndex, 0).toString());
				txtFname.setText(model.getValueAt(selectedIndex, 1).toString());
				txtLname.setText(model.getValueAt(selectedIndex, 2).toString());
				txtPnum.setText(model.getValueAt(selectedIndex, 3).toString());
				txtEmail.setText(model.getValueAt(selectedIndex, 4).toString());
				txtnic.setText(model.getValueAt(selectedIndex,5).toString());
				txtlic.setText(model.getValueAt(selectedIndex,6).toString());
			}
		});
		tableC.setToolTipText("");
		tableC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableC.setBackground(new Color(220, 220, 220));
		tableC.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		tableC.setModel(new DefaultTableModel(
			new Object[][] {
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
				"Customer Id", "First Name", "Last Name", "Phone No.", "Email", "NIC", "LIC"
			}
		));
		tableC.getColumnModel().getColumn(4).setPreferredWidth(147);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 73, 625, 528);
		contentPane.add(scrollPane);
		
		tableC.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
		scrollPane.setViewportView(tableC);
		tableC.setBounds(393, 89, 405, 216);
		
		JButton edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edit();
				txtFname.setText("");
				txtLname.setText("");
				txtPnum.setText("");
				txtEmail.setText("");
				txtnic.setText("");
				txtlic.setText("");
				 
				 autoid();
			}
			
		});
		edit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		edit.setBounds(214, 428, 140, 51);
		contentPane.add(edit);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				txtFname.setText("");
				txtLname.setText("");
				txtPnum.setText("");
				txtEmail.setText("");
				txtnic.setText("");
				txtlic.setText("");
				autoid();
				table_update();
			}
		});
		Delete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		Delete.setBounds(31, 502, 140, 51);
		contentPane.add(Delete);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtCusid.setText("");
				 txtFname.setText("");
				 txtLname.setText("");
				 txtPnum.setText("");
				 txtEmail.setText("");
				 txtnic.setText("");
				 txtlic.setText("");
				 autoid();
			}
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnCancel.setBounds(214, 502, 140, 51);
		contentPane.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 59, 390, 542);
		contentPane.add(panel);
		
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IT_Main_GUI g = new IT_Main_GUI();
				g.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(894, 34, 89, 23);
		contentPane.add(btnNewButton);
			
		autoid();
		table_update();
		
	}
	
	public void autoid(){
		CustomerController cus = new CustomerController();
		String max = cus.MaxcusID();
		if(max==null) {
        	txtCusid.setText("C0001");
        }else {
        	 // Extract the numeric portion of the ID (excluding the 'C' prefix)
            String numericPart = max.substring(1);

            // Parse the numeric portion as a long
            long id = Long.parseLong(numericPart);

            // Increment the ID to get the next value
            id ++;
            System.out.println(id);
            txtCusid.setText("C"+ String.format("%04d",id));
        }
	}
	
	public void table_update() {
            DefaultTableModel df = (DefaultTableModel) tableC.getModel();
            // Clear the existing rows in the table
            df.setRowCount(0);
            
            CustomerController cus = new CustomerController();
            Vector<Vector<Object>> data = cus.Read();
            
            for(Vector<Object> rowData: data) {
            	df.addRow(rowData);
            }
      
	}

	public void add() {
		String cusid= txtCusid.getText();
		String fname= txtFname.getText();
		String lname= txtLname.getText();
		String pno= txtPnum.getText();
		String email= txtEmail.getText();
		String  nic = txtnic.getText();
		String lic = txtlic.getText();
		
		CustomerController cus = new CustomerController(cusid,fname,lname,pno,email,nic,lic);
		cus.create();//adding to the customer database
		
		txtFname.setText("");
		txtLname.setText("");
		txtPnum.setText("");
		txtEmail.setText("");
		txtnic.setText("");
		txtlic.setText("");
		 
		 autoid();
		 table_update();
	}
	
	public void edit() {
		DefaultTableModel dmodel = (DefaultTableModel) tableC.getModel();
		
		int selectedIndex = tableC.getSelectedRow();
		String Cusid= dmodel.getValueAt(selectedIndex, 0).toString();
		String Fname= txtFname.getText();
		String Lname= txtLname.getText();
		String Pno= txtPnum.getText();
		String Email= txtEmail.getText();
		String nic = txtnic.getText();
		String lic = txtlic.getText();
		
		CustomerController cus = new CustomerController(Cusid,Fname,Lname,Pno,Email,nic,lic);
		cus.update();
		
		table_update();
	}
	
	public void delete() {
		
		DefaultTableModel dmodel = (DefaultTableModel) tableC.getModel();
		
		int selectedIndex = tableC.getSelectedRow();
		
		String Cusid= dmodel.getValueAt(selectedIndex, 0).toString();
	
		int dialogResult = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?", "Warning", JOptionPane.YES_NO_OPTION);
		
		if(dialogResult == JOptionPane.YES_OPTION) {
			System.out.println("Alo");
			CustomerController cus = new CustomerController(Cusid);
			cus.remove(Cusid);
		}
	}
	
}


