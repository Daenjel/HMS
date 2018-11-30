package hostelManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
    Border border = BorderFactory.createLineBorder(Color.red);

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 442, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(186, 101, 121, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 147, 121, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNewLabel.setBounds(90, 93, 86, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPassword.setBounds(90, 147, 86, 17);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 22));
		lblNewLabel_1.setBounds(166, 28, 86, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnExit.setBounds(142, 217, 70, 23);
		btnExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		contentPane.add(btnExit);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnLogin.setBounds(243, 217, 76, 23);
		btnLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ValidateUser();
			}
		});
		contentPane.add(btnLogin);
	}
	
	@SuppressWarnings("deprecation")
	public void ValidateUser(){
		if(txtUsername.getText().equals("")){
			txtUsername.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(passwordField.getText().equals("")){
			passwordField.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else {
		if(txtUsername.getText().equals("Admin") && passwordField.getText().equals("Admin")){
			JOptionPane.showMessageDialog(null,"Welcome to Hostel Management System");
			new Registration().setVisible(true);
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(null,"Incorrect UserName and Password");
		}
	}
	}
}
