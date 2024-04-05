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

public class IT_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IT_frame frame = new IT_frame();
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
	public IT_frame() {
		
		setTitle("Vehicle_Rental_System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 347, 431);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "IT_Main", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnReturn = new JButton("Return Car");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Return retn = new Return();
				retn.setVisible(true);
				
			}
		});
		btnReturn.setBounds(65, 141, 186, 53);
		panel.add(btnReturn);
		btnReturn.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setBounds(76, 324, 158, 44);
		panel.add(btnLogout);
		btnLogout.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		
		JButton btnRentAVehicle = new JButton("Rent");
		btnRentAVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Rent rent = new Rent();
				rent.setVisible(true);
			}
		});
		btnRentAVehicle.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btnRentAVehicle.setBounds(65, 57, 186, 53);
		panel.add(btnRentAVehicle);
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
