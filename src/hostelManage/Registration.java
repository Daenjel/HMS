package hostelManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstN;
	private JTextField txtSecondN;
	private JTextField txtStdID;
	JComboBox<Object> cmbGender,cmbHostelN,cmbHostelType;
	JLabel lblAmount;
	private JTextField txtStdEmail;
	private JTextField txtStdTel;
    static Connection myconn = null;
    Border border = BorderFactory.createLineBorder(Color.red);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 809, 528);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Hostel Management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 24));
		lblNewLabel.setBounds(185, 27, 445, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(79, 105, 82, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSecondName = new JLabel("Second Name:");
		lblSecondName.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSecondName.setBounds(231, 105, 107, 25);
		contentPane.add(lblSecondName);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStudentId.setBounds(79, 185, 82, 25);
		contentPane.add(lblStudentId);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblGender.setBounds(79, 233, 82, 25);
		contentPane.add(lblGender);
		
		txtFirstN = new JTextField();
		txtFirstN.setBorder(UIManager.getBorder("Button.border"));
		txtFirstN.setBounds(79, 141, 116, 20);
		contentPane.add(txtFirstN);
		txtFirstN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if(Character.isDigit(ch)){
					Toolkit.getDefaultToolkit().beep();
				   	evt.consume();
				JOptionPane.showMessageDialog(null, "Cannot Accept Numbers");
				}
			}
		});
		txtFirstN.setColumns(10);
		
		txtSecondN = new JTextField();
		txtSecondN.setBorder(UIManager.getBorder("Button.border"));
		txtSecondN.setColumns(10);
		txtSecondN.setBounds(231, 141, 116, 20);
		txtSecondN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if(Character.isDigit(ch)){
					Toolkit.getDefaultToolkit().beep();
				   	evt.consume();
				JOptionPane.showMessageDialog(null, "Cannot Accept Numbers");
				}
			}
		});
		contentPane.add(txtSecondN);
		
		txtStdID = new JTextField();
		txtStdID.setBorder(UIManager.getBorder("Button.border"));
		txtStdID.setColumns(10);
		txtStdID.setBounds(185, 188, 116, 20);
		txtStdID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if(!Character.isDigit(ch)){
					Toolkit.getDefaultToolkit().beep();
				   	evt.consume();
				JOptionPane.showMessageDialog(null, "Cannot Accept Letters");
				}
			}
		});
		contentPane.add(txtStdID);
		
		String [] gender = {"--Choose--","Male","Female"};
		
		cmbGender = new JComboBox<Object>(gender);
		cmbGender.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmbGender.setBounds(183, 236, 107, 20);
		contentPane.add(cmbGender);
		
		JLabel lblFeeAmount = new JLabel("Fee Amount:");
		lblFeeAmount.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblFeeAmount.setBounds(79, 376, 96, 25);
		contentPane.add(lblFeeAmount);
		
		lblAmount = new JLabel("0.0");
		lblAmount.setForeground(Color.RED);
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBackground(Color.WHITE);
		lblAmount.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAmount.setBounds(185, 376, 99, 25);
		contentPane.add(lblAmount);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(456, 105, 290, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHostelName = new JLabel("Hostel Name:");
		lblHostelName.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblHostelName.setBounds(10, 66, 107, 25);
		panel.add(lblHostelName);
		
		String [] hostelN = {"--Choose--","Amani Hostel","Heri Hostel","Wakes Hostel","Krypton Hostel"};
		cmbHostelN = new JComboBox<Object>(hostelN);
		cmbHostelN.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmbHostelN.setBounds(127, 69, 130, 20);
		cmbHostelN.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("5,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("10,000");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("9,500");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("11,00");
				}else if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("8,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("15,000");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("11,500");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("12,500");
				}else if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("11,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("18,500");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("15,000");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("14,500");
				}else if(cmbHostelN.getSelectedItem().equals("--Choose--") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("0.0");
				}else if(cmbHostelN.getSelectedItem().equals("--Choose--") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("0.0");
				}else if(cmbHostelN.getSelectedItem().equals("--Choose--") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("0.0");
				}
			}
			
		});
		panel.add(cmbHostelN);
		
		JLabel lblHostelType = new JLabel("Hostel Type:");
		lblHostelType.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblHostelType.setBounds(10, 112, 107, 25);
		panel.add(lblHostelType);
		
		String [] hostelTpe = {"--Choose--","Single","Double","Triple"};
		cmbHostelType = new JComboBox<Object>(hostelTpe);
		cmbHostelType.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmbHostelType.setBounds(127, 115, 130, 20);
		cmbHostelType.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("5,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("10,000");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("9,500");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Single")){
					lblAmount.setText("11,00");
				}else if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("8,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("15,000");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("11,500");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Double")){
					lblAmount.setText("12,500");
				}else if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("11,500");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("18,500");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("15,000");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("Triple")){
					lblAmount.setText("14,500");
				}else if(cmbHostelN.getSelectedItem().equals("Amani Hostel") && cmbHostelType.getSelectedItem().equals("--Choose--")){
					lblAmount.setText("0.0");
				}else if(cmbHostelN.getSelectedItem().equals("Heri Hostel") && cmbHostelType.getSelectedItem().equals("--Choose--")){
					lblAmount.setText("0.0");
				}else if(cmbHostelN.getSelectedItem().equals("Wakes Hostel") && cmbHostelType.getSelectedItem().equals("--Choose--")){
					lblAmount.setText("0.0");
				}else if(cmbHostelN.getSelectedItem().equals("Krypton Hostel") && cmbHostelType.getSelectedItem().equals("--Choose--")){
					lblAmount.setText("0.0");
				}
			}
			
		});
		panel.add(cmbHostelType);
		
		JLabel lblHostel = new JLabel("Hostel");
		lblHostel.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblHostel.setBounds(98, 22, 82, 25);
		panel.add(lblHostel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnRegister.setBounds(533, 404, 96, 25);
		btnRegister.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getDetails();
			}
			
		});
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Clear");
		btnCancel.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnCancel.setBounds(434, 404, 89, 25);
		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtFirstN.setText(null);
				txtSecondN.setText(null);
				txtStdID.setText(null);
				txtStdEmail.setText(null);
				txtStdTel.setText(null);
				cmbGender.setSelectedIndex(0);
				cmbHostelN.setSelectedIndex(0);
				cmbHostelType.setSelectedIndex(0);
				lblAmount.setText("0.0");
			}
		});
		contentPane.add(btnCancel);
		
		JLabel lblKsh = new JLabel("Ksh");
		lblKsh.setHorizontalAlignment(SwingConstants.LEFT);
		lblKsh.setForeground(Color.BLACK);
		lblKsh.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKsh.setBackground(Color.WHITE);
		lblKsh.setBounds(298, 376, 40, 25);
		contentPane.add(lblKsh);
		
		JLabel lblStudentEmail = new JLabel("Student Email:");
		lblStudentEmail.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStudentEmail.setBounds(79, 281, 116, 25);
		contentPane.add(lblStudentEmail);
		
		txtStdEmail = new JTextField();
		txtStdEmail.setBorder(UIManager.getBorder("Button.border"));
		txtStdEmail.setColumns(10);
		txtStdEmail.setBounds(203, 284, 199, 20);
		contentPane.add(txtStdEmail);
		
		JLabel lblStudentTel = new JLabel("Student Tel:");
		lblStudentTel.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStudentTel.setBounds(79, 317, 96, 25);
		contentPane.add(lblStudentTel);
		
		txtStdTel = new JTextField();
		txtStdTel.setBorder(UIManager.getBorder("Button.border"));
		txtStdTel.setColumns(10);
		txtStdTel.setBounds(203, 320, 116, 20);
		txtStdTel.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if(!Character.isDigit(ch)){
					Toolkit.getDefaultToolkit().beep();
				   	evt.consume();
				JOptionPane.showMessageDialog(null, "Cannot Accept Letters");
				}
			}
		});
		contentPane.add(txtStdTel);
		
		JButton btnAllotRoom = new JButton("Allot Rm");
		btnAllotRoom.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnAllotRoom.setBounds(650, 404, 96, 25);
		btnAllotRoom.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Allot().setVisible(true);
			}
		});
		contentPane.add(btnAllotRoom);
	}
	
	public void getDetails(){
		if(txtFirstN.getText().equals("")){
			txtFirstN.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(txtSecondN.getText().equals("")){
			txtSecondN.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(txtStdID.getText().equals("")){
			txtStdID.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(txtStdEmail.getText().equals("")){
			txtStdEmail.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(txtStdTel.getText().equals("")){
			txtStdTel.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(cmbGender.getSelectedIndex() == (0)){
			cmbGender.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(cmbHostelN.getSelectedIndex() == (0)){
			cmbHostelN.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(cmbHostelType.getSelectedIndex() == (0)){
			cmbHostelType.setBorder(border);
			JOptionPane.showMessageDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else{
			insert2Db();
			JOptionPane.showMessageDialog(null, "Registration Successful");
			Allot allt = new Allot();
			allt.txtAllotID.setText(txtStdID.getText().toString());
			allt.cmbAllotHstNm.setSelectedIndex(cmbHostelN.getSelectedIndex());
			allt.cmbAllotHstTpe.setSelectedIndex(cmbHostelType.getSelectedIndex());
			allt.btnSearch.setVisible(false);
			allt.setVisible(true);
			//dispose();
		}
	}
	
	public void insert2Db(){
		myconn = JConnection.ConnecrDb();
		
		String query = "insert into registration (FirstN,SecondN,StdID,Gender,StdEmail,StdTel,HostelN,HostelType,Amount) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = myconn.prepareStatement(query);
			stmt.setString(1, txtFirstN.getText().toString());
			stmt.setString(2, txtSecondN.getText().toString());
			stmt.setString(3, txtStdID.getText().toString());
			stmt.setString(4, cmbGender.getSelectedItem().toString());
			stmt.setString(5, txtStdEmail.getText().toString());
			stmt.setString(6, txtStdTel.getText().toString());
			stmt.setString(7, cmbHostelN.getSelectedItem().toString());
			stmt.setString(8, cmbHostelType.getSelectedItem().toString());
			stmt.setString(9, lblAmount.getText().toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
}
