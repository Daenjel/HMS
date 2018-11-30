package hostelManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
public class Allot extends JFrame {

	private JPanel contentPane;
	public JTextField txtAllotID;
	public JComboBox<Object> cmbAllotHstNm,cmbAllotHstTpe;
	static Connection myconn;
	public JButton btnSearch,btnBack;
    Border border = BorderFactory.createLineBorder(Color.red);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allot frame = new Allot();
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
	public Allot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 530, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllotRoom = new JLabel("Allot Room");
		lblAllotRoom.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblAllotRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllotRoom.setBounds(161, 21, 179, 31);
		contentPane.add(lblAllotRoom);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStudentId.setBounds(89, 90, 107, 25);
		contentPane.add(lblStudentId);
		
		JLabel lblHostelName = new JLabel("Hostel Name:");
		lblHostelName.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblHostelName.setBounds(89, 126, 107, 25);
		contentPane.add(lblHostelName);
		
		JLabel lblHostelType = new JLabel("Hostel Type:");
		lblHostelType.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblHostelType.setBounds(89, 175, 107, 25);
		contentPane.add(lblHostelType);
		
		txtAllotID = new JTextField();
		txtAllotID.setBounds(219, 93, 121, 20);
		contentPane.add(txtAllotID);
		txtAllotID.setColumns(10);
		
		String [] hostelN = {"--Choose--","Amani Hostel","Heri Hostel","Wakes Hostel","Krypton Hostel"};
		cmbAllotHstNm = new JComboBox<>(hostelN);
		cmbAllotHstNm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmbAllotHstNm.setBounds(219, 129, 121, 20);
		contentPane.add(cmbAllotHstNm);
		
		String [] hostelTpe = {"--Choose--","Single","Double","Triple"};
		cmbAllotHstTpe = new JComboBox<>(hostelTpe);
		cmbAllotHstTpe.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmbAllotHstTpe.setBounds(219, 175, 121, 20);
		contentPane.add(cmbAllotHstTpe);
		
		JButton btnARoom = new JButton("Allot Room");
		btnARoom.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnARoom.setBounds(309, 253, 121, 23);
		btnARoom.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jasperReport();
			}
		});
		contentPane.add(btnARoom);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnBack.setBounds(89, 253, 89, 23);
		btnBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Registration().setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnDelete.setBounds(198, 253, 89, 23);
		btnDelete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove4Db();
				txtAllotID.setText(null);
				cmbAllotHstNm.setSelectedIndex(0);
				cmbAllotHstTpe.setSelectedIndex(0);
			}
		});
		contentPane.add(btnDelete);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		btnSearch.setBounds(369, 92, 89, 23);
		btnSearch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search4Db();
			}
		});
		contentPane.add(btnSearch);
	}
	
	protected void jasperReport() {
		String reportpath = "C:\\Users\\daenjelk\\Documents\\Coordinates\\allotRoom.jrxml";
		//String reportpdf = "C:\\Users\\daenjelk\\Documents\\Coordinates\\allotRoom.pdf";
		//String deflt = "C:\\Users\\daenjelk\\Documents\\Coordinates\\JasperSoft\\DefaultSample.jrxml";
		
		try {
			myconn = JConnection.ConnecrDb();
			JasperReport js = JasperCompileManager.compileReport(reportpath);
			//JRDataSource jreData = new JREmptyDataSource();
			JasperPrint jp = JasperFillManager.fillReport(js,null,myconn);
			JasperViewer.viewReport(jp);
			//JasperExportManager.exportReportToPdfFile(jp,reportpdf);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		
	}
	public void remove4Db(){
		myconn = JConnection.ConnecrDb();
		
		String query = "delete from registration where StdID=? and HostelN=? and HostelType=?";
		if(txtAllotID.getText().equals("")){
			txtAllotID.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(cmbAllotHstNm.getSelectedIndex() == 0){
			cmbAllotHstNm.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else if(cmbAllotHstTpe.getSelectedIndex() == 0){
			cmbAllotHstTpe.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else {
		try {
			PreparedStatement stmt = myconn.prepareStatement(query);
			stmt.setString(1, txtAllotID.getText().toString());
			stmt.setString(2, cmbAllotHstNm.getSelectedItem().toString());
			stmt.setString(3, cmbAllotHstTpe.getSelectedItem().toString());
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Student ID: " +txtAllotID.getText().toString() +" has successfully been Deleted");
			myconn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		}
	}
	public void search4Db(){
		myconn = JConnection.ConnecrDb();
		
		String query = "select HostelN,HostelType from registration where StdID=?";
		
		if(txtAllotID.getText().equals("")){
			txtAllotID.setBorder(border);
			JOptionPane.showConfirmDialog(null,"Some Values are Empty, Please Input Values","Cannot Accept null functions",JOptionPane.OK_OPTION);
		}else {
		try {
			PreparedStatement stmt = myconn.prepareStatement(query);
			stmt.setString(1, txtAllotID.getText().toString());
			ResultSet myRs = stmt.executeQuery();
			
			if(!myRs.next()){
				JOptionPane.showMessageDialog(null, "No Records for Student ID: " +txtAllotID.getText().toString());
			}else{
				cmbAllotHstNm.setSelectedItem(myRs.getString("HostelN"));
				cmbAllotHstTpe.setSelectedItem(myRs.getString("HostelType"));
			}
			myconn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		}
	}
	protected void close() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

}
