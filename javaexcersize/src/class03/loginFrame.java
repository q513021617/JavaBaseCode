package class03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class loginFrame {

	private JFrame frmChartlogin;
	private JTextField textField;
	static loginFrame window = new loginFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frmChartlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChartlogin = new JFrame();
		frmChartlogin.setTitle("chartlogin");
		frmChartlogin.setBounds(100, 100, 450, 300);
		frmChartlogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChartlogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(227, 67, 171, 28);
		frmChartlogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("please enter userid:");
		lblNewLabel.setBounds(77, 66, 128, 28);
		frmChartlogin.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("enter chartRoom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				JOptionPane.showMessageDialog(null, , "info:", JOptionPane.INFORMATION_MESSAGE);
				
				window.frmChartlogin.setVisible(false);
				System.out.println(textField.getText());
				try {
					new client(Integer.parseInt(textField.getText()));
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(126, 153, 144, 37);
		frmChartlogin.getContentPane().add(btnNewButton);
	}
}
