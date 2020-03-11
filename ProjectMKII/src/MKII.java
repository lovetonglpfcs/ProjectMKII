import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


public class MKII extends JApplet implements ActionListener{
	public MKII() {
		getContentPane().setBackground(Color.DARK_GRAY);
	}
	boolean trig = false;
	Timer afk = new Timer(30000,this);
	private int Smoney=0;
	private String passLogin;
	private Connection con =null;
	private ResultSet rs = null;
	private PreparedStatement pst =null;
	private JTable tbcars;
	JComboBox combocars;
	private JScrollPane scrollPane_1,scrollPane_2;
	private JTable tbcustomers,thistable;
	private JTable tbhistory;
	private JTextField carregis;
	private JTextField carbrand;
	private JTextField carmodel;
	private JTextField carprice;
	private JTextField cartype;
	JButton btnNewButton_2,Login,Admin,Addcar,btnNewButton_1;
	private JTextField customname;
	private JTextField addresscustom;
	private JComboBox combodriverlc;
	private JPanel panel_2;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JButton btnNewButton_3;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnRent;
	public void init() {
		
		con=connect.ConnectDB();
		setSize(1200,800);
		getContentPane().setLayout(null);
		
		tbcars = new JTable();
		tbcars.setLocation(0, 77);
		tbcars.setSurrendersFocusOnKeystroke(true);
		tbcars.setFillsViewportHeight(true);
		tbcars.setCellSelectionEnabled(true);
		tbcars.setColumnSelectionAllowed(true);
		tbcars.setPreferredScrollableViewportSize(new Dimension(450,63));
		tbcars.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(tbcars);
		scrollPane.setBounds(399, 98, 789, 202);
		getContentPane().add(scrollPane);
		
		combocars = new JComboBox();
		combocars.setBounds(1010, 343, 178, 30);
		combocars.addItem("Customers");
		combocars.addItem("History");
		getContentPane().add(combocars);
		
		tbcustomers = new JTable();
		tbhistory = new JTable();
		scrollPane_1 = new JScrollPane(tbcustomers);
		scrollPane_1.setBounds(399, 400, 789, 239);
		scrollPane_2 = new JScrollPane(tbhistory);
		scrollPane_2.setBounds(399, 400, 789, 239);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel = new JLabel("418 Garage");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 39));
		lblNewLabel.setBounds(0, 13, 1200, 72);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(31, 93, 310, 280);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New Car");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(12, 13, 97, 34);
		panel.add(lblNewLabel_1);
		
		carregis = new JTextField();
		carregis.setBounds(81, 57, 185, 22);
		panel.add(carregis);
		carregis.setColumns(10);
		
		carbrand = new JTextField();
		carbrand.setColumns(10);
		carbrand.setBounds(81, 92, 185, 22);
		panel.add(carbrand);
		
		carmodel = new JTextField();
		carmodel.setColumns(10);
		carmodel.setBounds(81, 127, 185, 22);
		panel.add(carmodel);
		
		carprice = new JTextField();
		carprice.setColumns(10);
		carprice.setBounds(81, 162, 185, 22);
		panel.add(carprice);
		
		cartype = new JTextField();
		cartype.setColumns(10);
		cartype.setBounds(81, 197, 185, 22);
		panel.add(cartype);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E1B\u0E49\u0E32\u0E19\u0E17\u0E30\u0E40\u0E1A\u0E35\u0E22\u0E19");
		lblNewLabel_2.setBounds(12, 63, 94, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0E22\u0E35\u0E48\u0E2B\u0E49\u0E2D");
		lblNewLabel_3.setBounds(12, 98, 56, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0E23\u0E38\u0E48\u0E19");
		lblNewLabel_4.setBounds(12, 133, 56, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u0E23\u0E32\u0E04\u0E32/\u0E27\u0E31\u0E19");
		lblNewLabel_5.setBounds(12, 168, 56, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u0E1B\u0E23\u0E30\u0E40\u0E20\u0E17");
		lblNewLabel_6.setBounds(12, 203, 56, 16);
		panel.add(lblNewLabel_6);
		
		Addcar = new JButton("Add");
		Addcar.setBounds(12, 242, 97, 25);
		panel.add(Addcar);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setBounds(121, 242, 71, 25);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(204, 242, 97, 25);
		panel.add(btnNewButton_2);
		
		Admin = new JButton("Admin");
		Admin.setBounds(1091, 668, 97, 25);
		getContentPane().add(Admin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(31, 400, 310, 239);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New Customers");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(12, 13, 188, 16);
		panel_1.add(lblNewLabel_7);
		
		customname = new JTextField();
		customname.setBounds(103, 56, 163, 22);
		panel_1.add(customname);
		customname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setBounds(12, 59, 56, 16);
		panel_1.add(lblNewLabel_8);
		
		addresscustom = new JTextField();
		addresscustom.setBounds(103, 91, 163, 22);
		panel_1.add(addresscustom);
		addresscustom.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Address");
		lblNewLabel_10.setBounds(12, 94, 56, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Driver's License");
		lblNewLabel_11.setBounds(12, 129, 97, 16);
		panel_1.add(lblNewLabel_11);
		
		JButton addcustom = new JButton("Add");
		addcustom.setBounds(12, 201, 79, 25);
		panel_1.add(addcustom);
		
		JButton deletecustom = new JButton("Delete");
		deletecustom.setBounds(219, 201, 79, 25);
		panel_1.add(deletecustom);
		
		JButton editcustom = new JButton("Edit");
		editcustom.setBounds(103, 201, 97, 25);
		panel_1.add(editcustom);
		
		combodriverlc = new JComboBox();
		combodriverlc.setModel(new DefaultComboBoxModel(new String[] {"Have", "No"}));
		combodriverlc.setBounds(169, 126, 97, 22);
		panel_1.add(combodriverlc);
		
		Login = new JButton("Login");
		Login.setBounds(969, 668, 97, 25);
		getContentPane().add(Login);
		showDT();
		btnNewButton_2.addActionListener(this);
		combocars.addActionListener(this);
		Login.addActionListener(this);
		
		carregis.setEditable(false);
		carmodel.setEditable(false);
		carbrand.setEditable(false);
		carprice.setEditable(false);
		cartype.setEditable(false);
		Admin.setEnabled(false);
		Addcar.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 255, 204));
		panel_2.setBounds(31, 668, 894, 89);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Staff");
		lblNewLabel_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 26));
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setBounds(0, 0, 45, 16);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_12 = new JLabel("Car ");
		lblNewLabel_12.setBounds(35, 29, 56, 16);
		panel_2.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Customer ID");
		lblNewLabel_13.setBounds(35, 60, 116, 16);
		panel_2.add(lblNewLabel_13);
		
		btnNewButton_3 = new JButton("Return the car");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		btnNewButton_3.setForeground(new Color(0, 153, 255));
		btnNewButton_3.setBounds(633, 17, 236, 59);
		panel_2.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(155, 57, 187, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 26, 187, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		btnRent = new JButton("Rent");
		btnRent.setForeground(new Color(255, 51, 51));
		btnRent.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		btnRent.setBounds(385, 17, 236, 59);
		panel_2.add(btnRent);
		
		
	}
	public void showDT() {
		String sql = "select * from cars";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			tbcars.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			Logger.getLogger(MKII.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		sql = "select * from customers";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			tbcustomers.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			Logger.getLogger(MKII.class.getName()).log(Level.SEVERE,null,e);
			// TODO: handle exception
		}
		sql = "select * from history";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			tbhistory.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (SQLException e) {
			Logger.getLogger(MKII.class.getName()).log(Level.SEVERE,null,e);
			// TODO: handle exception
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(trig) {
			trig=false;
			afk.stop();
			carregis.setEditable(false);
			carmodel.setEditable(false);
			carbrand.setEditable(false);
			carprice.setEditable(false);
			cartype.setEditable(false);
			Admin.setEnabled(false);
			Addcar.setEnabled(false);
			btnNewButton_2.setEnabled(false);
			btnNewButton_1.setEnabled(false);
		}
		if(combocars.getSelectedItem()=="Customers") {
			getContentPane().add(scrollPane_1);
			getContentPane().remove(scrollPane_2);
		}else if(combocars.getSelectedItem()=="History"){
			getContentPane().add(scrollPane_2);
			getContentPane().remove(scrollPane_1);
		}
		if(btnNewButton_2==e.getSource()) {
			if (JOptionPane.showConfirmDialog(null, "[Delete].....Are you sure?", "WARNING",	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			    // yes option
			} else {
			    // no option
			}
		}else if(e.getSource()==Login) {
			passLogin=JOptionPane.showInputDialog("Password?");
			if(Integer.parseInt(passLogin)==1234) {
				carregis.setEditable(true);
				carmodel.setEditable(true);
				carbrand.setEditable(true);
				carprice.setEditable(true);
				cartype.setEditable(true);
				Admin.setEnabled(true);
				Addcar.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				trig=true;
				afk.start();
			}else {
				JOptionPane.showMessageDialog(null,"Wrong password!!!");
			}
			
		}
	}
}
