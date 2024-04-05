package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Model.MydbConnection;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import Controll.Vehicle_Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class Rent extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textScreen;
	private Map<String,String> hashmap;
	
	/**
	 * Launch the application.
	 */
	
	//fetching the hashmap
	{
	//non static block
		
		Vehicle_Controller vehi = new Vehicle_Controller();
		this.hashmap = vehi.getVehicle_available();
		
		System.out.println("vehicle Available hashmap is created");
		System.out.println("/-------------------------------------/");
		for(String str: hashmap.keySet()) {
			System.out.println(str + "," + hashmap.get(str));
		}
		System.out.println("/-------------------------------------/");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("start");
					Rent frame = new Rent();
					System.out.println("crash");

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
	public Rent() {
		System.out.println("Rent Frame Loaded");
		setTitle("Rent\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rent", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 25, 460, 458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblvehicleID = new JLabel("Vehicle ID :");
		lblvehicleID.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblvehicleID.setBounds(10, 43, 158, 41);
		panel.add(lblvehicleID);

		JButton btncancel = new JButton("Cancel");
		btncancel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btncancel.setBounds(27, 357, 112, 44);
		panel.add(btncancel);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btnNewButton.setBounds(134, 238, 191, 50);
		panel.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JComboBox<String> comboBoxvehicleid = new JComboBox<>();
		comboBoxvehicleid.setBounds(117, 52, 208, 28);
		for(String vid:this.hashmap.keySet()) {
			comboBoxvehicleid.addItem(vid);
		}
	
		comboBoxvehicleid.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println((String)comboBoxvehicleid.getSelectedItem());
				String selectedVID = (String)comboBoxvehicleid.getSelectedItem();
				String avaliabilty = hashmap.get(selectedVID);
				if(avaliabilty.equals("yes")) {
					textScreen.setText("    "+ selectedVID + " is Ready");
					btnNewButton.setEnabled(true);
					btnNewButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							//updating the vehicle table to availibity nope
							Vehicle_Controller vehi = new Vehicle_Controller(selectedVID);
							vehi.updateavailabilty(selectedVID,"not return");
							dispose();
							System.out.println("passing vid = " + selectedVID);
							RegisterFrame rf = new RegisterFrame(selectedVID);		
							rf.setVisible(true);			
						}});
					
					
				}else {
					textScreen.setText( "    "+selectedVID + " is Not! Ready");
					btnNewButton.setEnabled(false);
				}	
			}
		}); 		
		panel.add(comboBoxvehicleid);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IT_frame I = new IT_frame();
				I.setVisible(true);
			}
		});
		btnReturn.setBounds(296, 359, 112, 41);
		panel.add(btnReturn);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(39, 94, 395, 113);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textScreen = new JTextField();
		textScreen.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 24));
		textScreen.setColumns(10);
		textScreen.setBounds(10, 10, 375, 93);
		panel_1.add(textScreen);
	}
	
	
	
}
