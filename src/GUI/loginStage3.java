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

public class loginStage3 extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginStage3 frame = new loginStage3();
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
	public loginStage3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 582);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Admin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 431, 521);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Return");
		btnNewButton_4.setBounds(137, 435, 155, 54);
		panel.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginStage2 ls = new loginStage2();
				ls.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_3_1 = new JButton("Admin");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFrame ad = new AdminFrame();
				ad.setVisible(true);
			}
		});
		btnNewButton_3_1.setBounds(137, 341, 155, 60);
		panel.add(btnNewButton_3_1);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_3 = new JButton("Employee");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EmployeeFrame emp = new EmployeeFrame();
				emp.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(137, 249, 155, 60);
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_1 = new JButton("Customer Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerSearchFrame cus = new CustomerSearchFrame();
				cus.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(137, 166, 155, 60);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Transaction Search");
		btnNewButton_2.setBounds(137, 63, 155, 67);
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Search_Box_GUI s = new Search_Box_GUI();
				s.setVisible(true);
			}
		});
	}

}
