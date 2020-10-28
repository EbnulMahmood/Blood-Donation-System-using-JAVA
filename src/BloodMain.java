import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.sqlite.core.DB;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.print.DocFlavor.STRING;
import javax.swing.DefaultComboBoxModel;

public class BloodMain extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField bgroup;
	private JTextField address;
	private JTextField phone;
	private JTextField ref;
	private JTextField willing;
	private JComboBox will;
	private JComboBox bgrp;
	JTabbedPane tabbedPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodMain frame = new BloodMain();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection c = null;
	private JTextField blodgroup;
	private JTable searchtable;
	private JTextField na;
	private JTextField bg;
	private JTextField ad;
	private JTextField ph;
	private JTextField re;
	private JTextField wi;
	private JTable updatetable;
	private JTextField dlt;
	
	@SuppressWarnings("unchecked")
	public BloodMain() throws SQLException {
		setTitle("Blood Donation");
		setResizable(false);
		
		c = DriverManager.getConnection("JDBC:sqlite:D:\\181\\Object-Oriented Programming\\Java\\BloodDonation\\Blood.db");
//		JOptionPane.showMessageDialog(null, "Connection Successful.");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//NEW
				tabbedPane.setSelectedIndex(1);;
				
			}
		});
		menuItem.setBackground(Color.WHITE);
		mnFile.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("Exit");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//EXIT
				dispose();
				
			}
		});
		
		JMenuItem mntmSearch = new JMenuItem("Update");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Update
				tabbedPane.setSelectedIndex(2);;
			
			}
		});
		mntmSearch.setBackground(Color.WHITE);
		mnFile.add(mntmSearch);
		
		JMenuItem mntmSearch_1 = new JMenuItem("Search");
		mntmSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Search
				tabbedPane.setSelectedIndex(0);;
			
			}
		});
		mntmSearch_1.setBackground(Color.WHITE);
		mnFile.add(mntmSearch_1);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//About
				
				JFrame f = new JFrame();
				
				f.setTitle("About Us");
				f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				f.setBounds(0, 0, 400, 500);
				f.setResizable(false);
				f.getContentPane().setLayout(null);
				
				TextArea textArea = new TextArea();
				textArea.setText("Project Name      : BLOOOD DONATION\r\n\r\nGroup Members :\r\n\r\n1. Mirza Ebnul Mahmood Shovan (011 162 058)\r\nEmail: shovonmahmood67@gmail.com\r\n Mobile: +8801789546973\r\n\r\n2. Samir Hossain (011 162 075) \r\nEmail: santobepu@gmail.com\r\nMobile: +8801853750577\r\n\r\nProject  Characteristics :\r\n\r\ni. Donor information\r\nii. Search option\r\niii. Update option\r\n\r\nQuick Facts About the Blood Donation Process :\r\n\r\nBlood donation is a simple, four-step process: registration, medical history and mini-physical, \r\ndonation and refreshments. It is a safe process, and a sterile needle is used only once for \r\neach donor and then discarded.\r\n\r\nThe actual blood donation typically takes less than 10-12 minutes. The entire process, from \r\nthe time you arrive to the time you leave, takes about an hour and 15 minutes.\r\n\r\nThe average adult has about 10 pints of blood in his body. Roughly one pint is given during a donation.\r\n\r\nA healthy donor may donate red blood cells every 56 days, or double red cells every 112 days. \r\nThere are four types of transfusable products that can be derived from blood: red cells,\r\nplatelets, plasma and cryoprecipitate. Typically, two or three of these are produced from a pint\r\nof donated whole blood \u2014 hence each donation can help save more than one life.");
				textArea.setBounds(0, 0, 380, 461);
				f.getContentPane().add(textArea);
				f.setVisible(true);
			}
		});
		
		JMenuItem report = new JMenuItem("Report");
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Report
			JFrame f = new Report();	
			f.setVisible(true);
				
				
			}
		});
		report.setBackground(Color.WHITE);
		mnFile.add(report);
		mntmAbout.setBackground(Color.WHITE);
		mnFile.add(mntmAbout);
		menuItem_2.setBackground(Color.WHITE);
		mnFile.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tabbedPane.setBounds(10, 126, 1014, 502);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		tabbedPane.addTab("SEARCH", null, panel_1, null);
		panel_1.setLayout(null);
		
		blodgroup = new JTextField();
		blodgroup.setColumns(10);
		blodgroup.setBounds(122, 38, 176, 20);
		panel_1.add(blodgroup);
		
		JLabel lblBloodGroup_1 = new JLabel("Blood Group");
		lblBloodGroup_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblBloodGroup_1.setBounds(29, 30, 89, 35);
		panel_1.add(lblBloodGroup_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setIcon(new ImageIcon(BloodMain.class.getResource("/img/if_search_14646.png")));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//ADD SEARCH
			String bloodgrp = blodgroup.getText();
			String query1 = "select * from BloodDoner where bgroup = '"+bloodgrp+"'";
			try {
			PreparedStatement st1 = c.prepareStatement(query1);

			ResultSet rs = st1.executeQuery();
			
			searchtable.setModel(DbUtils.resultSetToTableModel(rs));
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
	      	}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(339, 36, 105, 23);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 90, 810, 375);
		panel_1.add(scrollPane);
		
		searchtable = new JTable();
		scrollPane.setViewportView(searchtable);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.YELLOW);
		tabbedPane.addTab("ADD DONER", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAddDonerInformation = new JLabel("ADD DONER INFORMATION");
		lblAddDonerInformation.setBounds(216, -2, 342, 67);
		lblAddDonerInformation.setBackground(Color.BLACK);
		lblAddDonerInformation.setForeground(Color.BLACK);
		lblAddDonerInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDonerInformation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblAddDonerInformation);
		
		JLabel lblNewLabel = new JLabel("Name\r\n");
		lblNewLabel.setBounds(26, 71, 52, 35);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(114, 79, 176, 20);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(26, 110, 90, 35);
		lblBloodGroup.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblBloodGroup);
		
		bgroup = new JTextField();
		bgroup.setBackground(Color.ORANGE);
		bgroup.setBounds(114, 118, 0, 20);
		bgroup.setColumns(10);
		panel.add(bgroup);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(26, 149, 52, 35);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setBounds(114, 157, 176, 20);
		address.setColumns(10);
		panel.add(address);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(26, 188, 52, 35);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblPhone);
		
		phone = new JTextField();
		phone.setBounds(114, 196, 176, 20);
		phone.setColumns(10);
		panel.add(phone);
		
		JLabel lblReference = new JLabel("Reference");
		lblReference.setBounds(26, 227, 78, 35);
		lblReference.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblReference);
		
		ref = new JTextField();
		ref.setBounds(114, 235, 176, 20);
		ref.setColumns(10);
		panel.add(ref);
		
		JLabel lblWilling = new JLabel("Willing");
		lblWilling.setBounds(26, 266, 52, 35);
		lblWilling.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(lblWilling);
		
		willing = new JTextField();
		willing.setEnabled(false);
		willing.setBackground(Color.ORANGE);
		willing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		willing.setBounds(114, 274, -8, 20);
		willing.setColumns(10);
		panel.add(willing);
		
		JButton AddDoner = new JButton("ADD DONER");
		AddDoner.setIcon(new ImageIcon(BloodMain.class.getResource("/img/if_add_small_14227.png")));
		AddDoner.setBounds(26, 342, 129, 25);
		AddDoner.setFont(new Font("Tahoma", Font.BOLD, 11));
		AddDoner.setBackground(Color.BLUE);
		AddDoner.setForeground(Color.WHITE);
		AddDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			//ADD DONER
			String bgp = (String)bgrp.getSelectedItem();
			String wilng = (String)will.getSelectedItem();
			String nm = name.getText();
			String bg = bgp;
			String adrs = address.getText();
			String phn = phone.getText();
			String rf = ref.getText();
			String will = wilng;
				
			String query = "insert into BloodDoner(Name, Bgroup, Address, Phone, Reference, Willing) "
					+ "values('"+nm+"', '"+bg+"', '"+adrs+"', '"+phn+"', '"+rf+"', '"+will+"')";
			try {
			PreparedStatement st = c.prepareStatement(query);
			st.execute();
			JOptionPane.showMessageDialog(null, "Doner Add Successful.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		panel.add(AddDoner);
		
		will = new JComboBox();
		will.setBackground(Color.WHITE);
		will.setForeground(Color.BLACK);
		will.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		will.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO", "MAYBE"}));
		will.setBounds(114, 273, 176, 22);
		panel.add(will);
		
		bgrp = new JComboBox();
		bgrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bgrp.setModel(new DefaultComboBoxModel(new String[] {"AB+", "AB-", "A+", "A-", "O+", "O-", "B+", "B-"}));
		bgrp.setBackground(Color.WHITE);
		bgrp.setForeground(Color.BLACK);
		bgrp.setBounds(114, 117, 176, 22);
		panel.add(bgrp);
		
		JPanel delete = new JPanel();
		delete.setForeground(Color.BLACK);
		delete.setBackground(Color.YELLOW);
		tabbedPane.addTab("UPDATE", null, delete, null);
		delete.setLayout(null);
		
		JLabel label = new JLabel("Name\r\n");
		label.setBounds(26, 23, 52, 35);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label);
		
		na = new JTextField();
		na.setBounds(114, 31, 176, 20);
		na.setEditable(false);
		na.setColumns(10);
		delete.add(na);
		
		bg = new JTextField();
		bg.setBounds(114, 70, 176, 20);
		bg.setColumns(10);
		delete.add(bg);
		
		JLabel label_1 = new JLabel("Blood Group");
		label_1.setBounds(26, 62, 90, 35);
		label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(26, 101, 52, 35);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label_2);
		
		ad = new JTextField();
		ad.setBounds(114, 109, 176, 20);
		ad.setColumns(10);
		delete.add(ad);
		
		JLabel label_3 = new JLabel("Phone");
		label_3.setBounds(376, 23, 52, 35);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label_3);
		
		ph = new JTextField();
		ph.setBounds(464, 31, 176, 20);
		ph.setColumns(10);
		delete.add(ph);
		
		re = new JTextField();
		re.setBounds(464, 70, 176, 20);
		re.setColumns(10);
		delete.add(re);
		
		JLabel label_4 = new JLabel("Reference");
		label_4.setBounds(376, 62, 78, 35);
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label_4);
		
		JLabel label_5 = new JLabel("Willing");
		label_5.setBounds(376, 101, 52, 35);
		label_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		delete.add(label_5);
		
		wi = new JTextField();
		wi.setBounds(464, 109, 176, 20);
		wi.setColumns(10);
		delete.add(wi);
		
		JButton btnUpdateDoner = new JButton("UPDATE");
		btnUpdateDoner.setIcon(new ImageIcon(BloodMain.class.getResource("/img/if_refresh_41218.png")));
		btnUpdateDoner.setBounds(26, 153, 101, 23);
		btnUpdateDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//UPDATE DONER
			String nm1 = na.getText();
			String bg1 = bg.getText();
			String adrs1 = ad.getText();
			String phn1 = ph.getText();
			String rf1 = re.getText();
			String will1 = wi.getText();
					
			String query4 = "Update BloodDoner Set Name = '"+nm1+"', Bgroup = '"+bg1+"', Address = '"+adrs1+"', Phone = '"+phn1+"', Reference = '"+rf1+"',"
					+ " Willing = '"+will1+"' where Name = '"+nm1+"'";
			try {
			PreparedStatement st4 = c.prepareStatement(query4);
			st4.execute();
			JOptionPane.showMessageDialog(null, "Doner Updated.");
			} catch (SQLException e2) {
			// TODO Auto-generated catch block
    			e2.printStackTrace();
         	}
			
			}
		});
		btnUpdateDoner.setForeground(Color.WHITE);
		btnUpdateDoner.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateDoner.setBackground(Color.BLUE);
		delete.add(btnUpdateDoner);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 192, 803, 281);
		delete.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row = updatetable.getSelectedRow();
				String n = updatetable.getModel().getValueAt(row, 0).toString();
				
				String query3 = "select * from BloodDoner where name = '"+n+"'";
				try {
				PreparedStatement st3 = c.prepareStatement(query3);

				ResultSet rs3 = st3.executeQuery();
				
				while (rs3.next()) {
					na.setText(rs3.getString("Name"));
					bg.setText(rs3.getString("Bgroup"));
					ad.setText(rs3.getString("Address"));
					ph.setText(rs3.getString("Phone"));
					re.setText(rs3.getString("Reference"));
					wi.setText(rs3.getString("Willing"));
				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		scrollPane_1.setViewportView(updatetable);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setIcon(new ImageIcon(BloodMain.class.getResource("/img/if_stock_show-form-dialog_21426.png")));
		btnShow.setBounds(189, 153, 101, 23);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//SHOW
			
			String query2 = "select * from BloodDoner";
			try {
			PreparedStatement st2 = c.prepareStatement(query2);
		
			ResultSet rs2 = st2.executeQuery();
			updatetable.setModel(DbUtils.resultSetToTableModel(rs2));
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block					
				e1.printStackTrace();
			}
		  }
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnShow.setBackground(Color.BLUE);
		delete.add(btnShow);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setIcon(new ImageIcon(BloodMain.class.getResource("/img/if_Delete_132746.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//DELETE
				
				String query5 = "delete from BloodDoner where Name = ?";
				try {
				PreparedStatement st5 = c.prepareStatement(query5);

				st5.setString(1, dlt.getText());
				
				st5.execute();
				
				} catch (SQLException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(665, 153, 101, 23);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(Color.BLUE);
		delete.add(btnDelete);
		
		dlt = new JTextField();
		dlt.setColumns(10);
		dlt.setBounds(464, 154, 176, 20);
		delete.add(dlt);
		
		JLabel label_6 = new JLabel("Name\r\n");
		label_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		label_6.setBounds(376, 146, 52, 35);
		delete.add(label_6);
		
		JLabel lblBloodDonation = new JLabel("BLOOD DONATION");
		lblBloodDonation.setForeground(new Color(255, 69, 0));
		lblBloodDonation.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblBloodDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodDonation.setBounds(324, 23, 437, 74);
		contentPane.add(lblBloodDonation);
	}
}
