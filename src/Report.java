import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTextArea reports;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Report() {
		setResizable(false);
		setTitle("Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 461, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 99, 71));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		reports = new JTextArea();
		reports.setText("What went wrong?");
		reports.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		reports.setToolTipText("");
		reports.setBounds(0, 22, 445, 196);
		contentPane.add(reports);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String srt = reports.getText();
				String output = "D:\\181\\Object-Oriented Programming\\Java\\BloodDonation\\report\\reports.txt";

				try {
					FileWriter fileWriter = new FileWriter(output);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(srt);
					bufferedWriter.flush();
					bufferedWriter.close();
					dispose();

				} catch (FileNotFoundException e) {
					System.out.println("Unable to open file '" + output + "'");
				} catch (IOException ex) {
					System.out.println("Error writing to file '" + output + "'");
					// Or we could just do this:
					// ex.printStackTrace();
				}

			}
		});
		ok.setForeground(new Color(0, 0, 0));
		ok.setBackground(Color.WHITE);
		ok.setBounds(167, 220, 89, 23);
		contentPane.add(ok);
		
		JLabel lblReportAProblem = new JLabel("Report a problem");
		lblReportAProblem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReportAProblem.setForeground(new Color(0, 0, 0));
		lblReportAProblem.setBackground(new Color(30, 144, 255));
		lblReportAProblem.setBounds(0, 0, 142, 23);
		contentPane.add(lblReportAProblem);
	}
}
