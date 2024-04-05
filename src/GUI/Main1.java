package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 frame = new Main1();
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
	public Main1() {
		
		setTitle("Vehicle_Rental_System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVehicleRegisteration = new JButton("Vehicle Registeration");
		btnVehicleRegisteration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Vehicle_Registration vr = new Vehicle_Registration();
				//vr.setVisible(true);
			}
		});
		btnVehicleRegisteration.setBounds(127, 10, 186, 25);
		contentPane.add(btnVehicleRegisteration);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(127, 63, 186, 25);
		contentPane.add(btnCustomer);
		
		JButton btnRental = new JButton("Rental");
		btnRental.setBounds(127, 113, 186, 25);
		contentPane.add(btnRental);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(127, 173, 186, 25);
		contentPane.add(btnReturn);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(139, 401, 186, 25);
		contentPane.add(btnLogout);
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
