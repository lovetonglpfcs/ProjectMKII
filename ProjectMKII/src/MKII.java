import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.*;
import net.proteanit.sql.DbUtils;

import javax.swing.JApplet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;


public class MKII extends JApplet implements ActionListener{
	public MKII() {
		getContentPane().setBackground(Color.DARK_GRAY);
	}
	private Connection con =null;
	private ResultSet rs = null;
	private PreparedStatement pst =null;
	private JTable tbcars;
	JComboBox combocars;
	private JScrollPane scrollPane_1,scrollPane_2;
	private JTable tbcustomers,thistable;
	private JTable tbhistory;
	public void init() {
		
		con=connect.ConnectDB();
		setSize(1200,800);
		getContentPane().setLayout(null);
		
		tbcars = new JTable();
		tbcars.setSurrendersFocusOnKeystroke(true);
		tbcars.setFillsViewportHeight(true);
		tbcars.setCellSelectionEnabled(true);
		tbcars.setColumnSelectionAllowed(true);
		tbcars.setBounds(235, 29, 527, 188);
		tbcars.setPreferredScrollableViewportSize(new Dimension(450,63));
		tbcars.setFillsViewportHeight(true);
		
		getContentPane().add(tbcars);
		
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
		showDT();
		combocars.addActionListener(this);
	}
	public void showDT() {
		String sql = "select * from cars";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("Price/Day"));
			}
			tbcars.setModel(new DefaultTableModel(
				new Object[][] {
					{"\u0E01\u0E01-4640", "Hyundai", "Elite", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E01\u0E04-9452", "Nissan", "March", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E01\u0E08-4497", "Honda", "Jazz", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E01\u0E08-5869", "Nissan", "Sylphy", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E01\u0E09-6348", "Isuzu", "D-Max Hi Render", null, "\u0E23\u0E16\u0E01\u0E23\u0E30\u0E1A\u0E30", "complete"},
					{"\u0E01\u0E10-9213", "Toyota", "Revo", null, "\u0E23\u0E16\u0E01\u0E23\u0E30\u0E1A\u0E30", "complete"},
					{"\u0E01\u0E13-7149", "Toyota", "Innova", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E01\u0E15-5487", "Toyota", "Yaris", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E01\u0E17-2378", "Honda", "Amaze", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E01\u0E19-6150", "Nissan", "Almera", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E01\u0E21-2359", "Hyundai", "H-1", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E01\u0E23-1219", "Nissan", "Teana", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E01\u0E2A-7021", "Honda", "Civic", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E01\u0E2D-2546", "BMW", "X1", null, "\u0E23\u0E16\u0E2A\u0E1B\u0E2D\u0E23\u0E4C\u0E15", "complete"},
					{"\u0E02\u0E15-2118", "Honda", "Spada", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E0A\u0E22-3711", "Hyundai", "Deluxe", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E0A\u0E29-6688", "BMW", "230d", null, "\u0E23\u0E16\u0E2A\u0E1B\u0E2D\u0E23\u0E4C\u0E15", "complete"},
					{"\u0E0D\u0E15-6011", "Mercedes Benz", "C220d", null, "\u0E23\u0E16\u0E2A\u0E1B\u0E2D\u0E23\u0E4C\u0E15", "complete"},
					{"\u0E0E\u0E01-1773", "Mercedes Benz", "C350", null, "\u0E23\u0E16\u0E2A\u0E1B\u0E2D\u0E23\u0E4C\u0E15", "complete"},
					{"\u0E16\u0E0A-8449", "Isuzu", "D-Max Space cab", null, "\u0E23\u0E16\u0E01\u0E23\u0E30\u0E1A\u0E30", "complete"},
					{"\u0E1A\u0E18-1989", "Honda", "Brio", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E1A\u0E1E-4933", "Mitsubishi", "Mirage", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E1A\u0E23-8796", "Honda", "Mobilio", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E1A\u0E29-8452", "Honda", "City", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E1C\u0E01-2394", "Mitsubishi", "Attrage", null, "\u0E23\u0E16\u0E02\u0E19\u0E32\u0E14\u0E40\u0E25\u0E47\u0E01", "complete"},
					{"\u0E1C\u0E04-1638", "Toyota", "Altis", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
					{"\u0E1C\u0E08-6754", "Toyota", "Sienta", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E1C\u0E19-3922", "Isuzu", "HR", null, "\u0E23\u0E16\u0E01\u0E23\u0E30\u0E1A\u0E30", "complete"},
					{"\u0E1C\u0E2B-3215", "Mitsubishi", "Xpander", null, "\u0E23\u0E16\u0E15\u0E39\u0E49", "complete"},
					{"\u0E29\u0E2B-4681", "Toyota", "Vios", null, "\u0E23\u0E16\u0E40\u0E01\u0E4B\u0E07", "complete"},
				},
				new String[] {
					"Vehicle registration", "Car brand", "Car model", "Price/Day", "Type car", "status"
				}
			));
		} catch (SQLException e) {
			//Logger.getLogger(MKII.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		sql = "select * from customers";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			tbcustomers.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			// TODO: handle exception
		}
		sql = "select * from history";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			tbhistory.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void actionPerformed(ActionEvent event) {
		System.out.println(combocars.getSelectedItem()=="History");
		if(combocars.getSelectedItem()=="Customers") {
			getContentPane().add(scrollPane_1);
		}else if(combocars.getSelectedItem()=="History"){
			getContentPane().add(scrollPane_2);
		}
	}
}
