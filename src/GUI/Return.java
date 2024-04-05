package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controll.CustomerController;
import Controll.Transaction_Controller;
import Controll.Vehicle_Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.event.ActionEvent;

public class Return extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textScreen1;
	private JTextField textscreen2;
	private Set<String> cuslist;
	private JTextField textnocusvehi;
	private String V_ID;
	//private Vector<String> cuslsit = getcusList() ;
	/**
	 * Launch the application.
	 */
	//fetching Customer list
	{
		//non static block
		Transaction_Controller trans = new Transaction_Controller();
		this.cuslist = trans.getcusList();
	
		for(String str: cuslist) {
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		
		Return r = new Return();
		//r.setCuslsit(null);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
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
	public Return() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Return", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 466, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblcus = new JLabel("Customer ID   :");
		lblcus.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblcus.setBounds(10, 38, 110, 26);
		panel.add(lblcus);
		
		JPanel screen = new JPanel();
		screen.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		screen.setBounds(10, 90, 446, 129);
		panel.add(screen);
		screen.setLayout(null);
		
		textScreen1 = new JTextField();
		textScreen1.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		textScreen1.setText("");
		textScreen1.setBounds(10, 11, 426, 43);
		screen.add(textScreen1);
		textScreen1.setColumns(10);
		
		textscreen2 = new JTextField();
		textscreen2.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		textscreen2.setText("");
		textscreen2.setColumns(10);
		textscreen2.setBounds(10, 75, 426, 43);
		screen.add(textscreen2);
		
		textnocusvehi = new JTextField();
		textnocusvehi.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		textnocusvehi.setBounds(10, 21, 426, 86);
		screen.add(textnocusvehi);
		textnocusvehi.setColumns(10);
		textnocusvehi.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Transaction_Vehicle_Customer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(486, 11, 548, 482);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 528, 448);
		panel_1.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"transactionID", "vehicleID", "customerID"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(10, 274, 132, 46);
		panel.add(btnDone);
		btnDone.setEnabled(false);
		
		JComboBox<String> cuscomboBox = new JComboBox<>();
		cuscomboBox.setBounds(130, 38, 115, 27);
		for(String vid:this.cuslist) {
			cuscomboBox.addItem(vid);
		}
		cuscomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CID = (String)cuscomboBox.getSelectedItem();
				//now we should take the relavant VIDs
				System.out.println("Vehicle IDs");
				
				//
				Transaction_Controller trans = new Transaction_Controller();
				Vector<String> vehiclelist = trans.getCusvehicList(CID);
				
				Vehicle_Controller vehi = new Vehicle_Controller();
				//all the vehicles
				Map<String, String> Vehicle_Controller = vehi.getVehicle_available(); 
				
				//customers vehicle-availabilty hasmap
				
				//V0001 -> yes
				//V0002 -> no
				//V0003 -> no
				Map<String, String> cus_vehi_availabiltyMAP = new ConcurrentHashMap<String,String>();;
				
				//custoemrs vehicle list
				System.out.println("/----vehiclelist-----------------------/");
				for(String str:vehiclelist) {
					System.out.println(str);
				}
				System.out.println("/---------------------------/");
				System.out.println(" " + vehiclelist.size());
				
				int flag = 0;//yes count
				int count = 0;// vehicle count
				String option1 = "yes";
				String option2 = "no";
				//System.out.println("/-----------332----------------/");
				//checking the availabilty
				for(String V_ID:vehiclelist) {
					count++;
					//checking the availabilty
					String available =  Vehicle_Controller.get(V_ID);
					if(available.equals(option1)) {
						cus_vehi_availabiltyMAP.put(V_ID, option1);
						flag++;
						continue;
					}else if(available.equals(option2)) {
						cus_vehi_availabiltyMAP.put(V_ID, option2);
					}else {
						System.out.println("check the program , availibility map is bugged!");
					}
					
				}
				//flag , count , availbity map is set
				//flag > count -> debt
				//flag = count paid 

				System.out.println(" ane print wennnako");
				//printing availability map
				for(String str:cus_vehi_availabiltyMAP.keySet()) {
					System.out.println(cus_vehi_availabiltyMAP.get(str));
				}
		
				if(cus_vehi_availabiltyMAP.size() == 0) {
					System.out.println("cus_vehi_availabiltyMAP.size() == 0 ");
					textScreen1.setVisible(false);
					textscreen2.setVisible(false);
					textnocusvehi.setVisible(true);
					table.setVisible(false);
					textnocusvehi.setText(CID + "  hasn't rented any vehicles!");
				}else if(flag == count) {
					System.out.println("flag == count");
					textScreen1.setVisible(false);
					textscreen2.setVisible(false);
					textnocusvehi.setVisible(true);
					table.setVisible(false);
					textnocusvehi.setText(CID + "  has paid for rented vehicles!");
				}else{
					System.out.println("flag < count");
					table.setVisible(true);
					textnocusvehi.setVisible(false);
					textScreen1.setVisible(true);
					textscreen2.setVisible(true);
					
					//cus_vehi_availabiltyMAP 

					String option = "no";
					String V_ID = null;
					Double tot = 0.0;
					Transaction_Controller vehictotal = new Transaction_Controller();
					for (Map.Entry<String, String> entry : cus_vehi_availabiltyMAP.entrySet()) {
						if (entry.getValue().equals(option)) {
							V_ID = entry.getKey();
								//total calualatiom
								//get the transaction list
							System.out.println(V_ID);
							String transID = vehictotal.getTransID(V_ID);
							System.out.println(transID);
							tot += vehictotal.GetDueAmount(transID);
							System.out.println(tot);
								
						}else {
						}
					}
				       
					textScreen1.setText("  Vehicle ID = " + vehiclelist);
					textscreen2.setText("  Amount = " + tot + " /=");
					
					System.out.println("total of CIDs = " + tot);
							
					   //done
				       btnDone.setEnabled(true);
				       Vehicle_Controller vehicle = new Vehicle_Controller();
				       Transaction_Controller trans_u = new Transaction_Controller(V_ID);
				       
				       for(String str:vehiclelist) {
					       btnDone.addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent e) {
					    		  
					    		   //availibilty of the vehicle -> yes
					    		   vehicle.updateavailabilty(str,"return");
					    		   
					    		   //transaction not return to return 
					    		   System.out.println("str = " + str);
					    		   String T_ID = trans_u.getTransID(str);
					    		   System.out.println("T_ID = " + T_ID);
					    		   trans_u.updateTransactionStatus(T_ID,"return");  
					    	   }
					       });
						}
				      }
				}
			}
		);
		panel.add(cuscomboBox);
			
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textScreen1.setText("");
				textscreen2.setText("");
				table_update();
			}
		});
		btnReset.setBounds(324, 274, 132, 46);
		panel.add(btnReset);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IT_frame I = new IT_frame();
				I.setVisible(true);
			}
		});
		btnReturn.setBounds(167, 387, 132, 46);
		panel.add(btnReturn);
		
		table_update();
	}
	
	public void table_update() {
		DefaultTableModel df = (DefaultTableModel) table.getModel();
        // Clear the existing rows in the table
        df.setRowCount(0);
        
        Transaction_Controller trans = new Transaction_Controller();
        Vector<Vector<Object>> data = trans.Read();
        
        for(Vector<Object> rowData: data) {
        	df.addRow(rowData);
        }
	}
	
	public String getV_ID() {
		return V_ID;
	}


	public void setV_ID(String v_ID) {
		V_ID = v_ID;
	}
}
