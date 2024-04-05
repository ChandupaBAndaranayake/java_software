package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class IT_Main_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IT_Main_GUI frame = new IT_Main_GUI();
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
	public IT_Main_GUI() {
		
		setTitle("Vehicle_Rental_System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 425, 439);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "IT_Main", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnVehicleRegisteration = new JButton("Vehicle Registeration");
		btnVehicleRegisteration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VehicleFrame vehi = new VehicleFrame();
				vehi.setVisible(true);
			}
		});
		btnVehicleRegisteration.setBounds(100, 38, 186, 61);
		panel.add(btnVehicleRegisteration);
		btnVehicleRegisteration.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JButton btnCustomer = new JButton("Customer Registration");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerFrame c = new CustomerFrame();
				c.setVisible(true);
				
				
				
			}
		});
		btnCustomer.setBounds(100, 129, 186, 54);
		panel.add(btnCustomer);
		btnCustomer.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.setBounds(100, 209, 186, 54);
		panel.add(btnTransactions);
		btnTransactions.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JButton btnLogout = new JButton("Return");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginStage2 l = new loginStage2();
				l.setVisible(true);
			}
		});
		btnLogout.setBounds(111, 336, 158, 44);
		panel.add(btnLogout);
		btnLogout.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TransactionFrame tr = new TransactionFrame();
				tr.setVisible(true);
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public void Main1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
