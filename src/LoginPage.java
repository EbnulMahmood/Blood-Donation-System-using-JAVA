import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setResizable(false);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(210, 105, 30));
		panel.setBounds(0, 0, 534, 361);
		contentPane.add(panel);
		
		JLabel label = new JLabel(" Password :");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(54, 105, 77, 14);
		panel.add(label);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(141, 59, 140, 20);
		panel.add(username);
		
		JLabel label_1 = new JLabel("User Name :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBackground(SystemColor.menu);
		label_1.setBounds(54, 61, 77, 14);
		panel.add(label_1);
		
		JButton login = new JButton("Log In");
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(138, 43, 226));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//LogIn
			String pass = password.getText();
			String user = username.getText();
			
			if ((user.contains("shovon") || user.contains("santo")) && pass.contains("1234")) {
				password.setText(null);
				username.setText(null);
				try {
					BloodMain frame = new BloodMain();
					frame.setVisible(true);
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				password.setText(null);
				username.setText(null);
			}
			
			}
		});
		login.setBounds(42, 255, 89, 23);
		panel.add(login);
		
		JButton button_1 = new JButton("Reset");
		button_1.setBackground(new Color(138, 43, 226));
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Reset
			username.setText(null);
			password.setText(null);
			
			}
		});
		button_1.setBounds(214, 255, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Exit");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(138, 43, 226));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Exit
			JFrame exit = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(exit, "Confirm if you want to exit", "Login Systems",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			
			}
		});
		button_2.setBounds(388, 255, 89, 23);
		panel.add(button_2);
		
		password = new JPasswordField();
		password.setBounds(141, 103, 140, 20);
		panel.add(password);
	}
}
