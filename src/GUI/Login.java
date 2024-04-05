package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controll.login_Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox chckbxAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Vehicel_Rental_System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogin.setBounds(51, 12, 70, 15);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(51, 51, 102, 15);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(171, 49, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 96, 114, 19);
		contentPane.add(passwordField);
		
		JLabel lblUsername_1 = new JLabel("password");
		lblUsername_1.setBounds(51, 98, 102, 15);
		contentPane.add(lblUsername_1);
		
		chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setBounds(51, 156, 129, 23);
		contentPane.add(chckbxAdmin);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (chckbxAdmin.isSelected()) {
					login_Controller l = new login_Controller();
				    Vector<String> adminPasswords = l.getAdminpasswords(); // Assuming you have a method like this
				    Vector<String> usernames = l.getAdminUsername(); // Assuming you have a method like this

				    String enteredUsername = textField.getText();
				    String enteredPassword = new String(passwordField.getPassword());

				    boolean userFound = false;
				    
				    for (int i = 0; i < usernames.size(); i++) {
				        if (enteredUsername.equals(usernames.get(i))) {
				            if (enteredPassword.equals(adminPasswords.get(i))) {
				                dispose();
				               loginStage2 lg = new loginStage2();
				                lg.setVisible(true);
				            } else {
				                JOptionPane.showMessageDialog(btnOk, "Password incorrect");
				            }
				            userFound = true;
				            break; // No need to continue searching
				        }
				    }

				    if (!userFound) {
				        JOptionPane.showMessageDialog(btnOk, "User incorrect");
				    }
				}else {
				    login_Controller l = new login_Controller();
				    Vector<String> employeePasswords = l.getEmployeePassword(); // Assuming you have a method like this
				    Vector<String> employeeUsernames = l.getEmployeeUsername(); // Assuming you have a method like this
				    

				    String enteredUsername = textField.getText();
				    String enteredPassword = new String(passwordField.getPassword());

				    boolean userFound = false;
				    
				    for (int i = 0; i < employeeUsernames.size(); i++) {
				        if (enteredUsername.equals(employeeUsernames.get(i))) {
				            if (enteredPassword.equals(employeePasswords.get(i))) {
				                dispose();
				                IT_frame m = new IT_frame();
				                m.setVisible(true);
				            } else {
				                JOptionPane.showMessageDialog(btnOk, "Password incorrect");
				            }
				            userFound = true;
				            break; // No need to continue searching
				        }
				    }

				    if (!userFound) {
				        JOptionPane.showMessageDialog(btnOk, "User incorrect");
				    }else {
				    	
				    }
				}
			}
		});
		btnOk.setBounds(36, 223, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(171, 223, 117, 25);
		contentPane.add(btnCancel);
		
	}
	
}
