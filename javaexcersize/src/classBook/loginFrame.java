package classBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class loginFrame {
	Socket socket;
	PrintWriter pWrite;
	BufferedReader bReader;
	private JFrame frmChartlogin;
	private JTextField nameTextField;
	private JTextField passwordTextField;
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
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public loginFrame(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	private void initialize() {
		frmChartlogin = new JFrame();
		frmChartlogin.setTitle("login");
		frmChartlogin.setBounds(100, 100, 450, 300);
		frmChartlogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmChartlogin.getContentPane().setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(227, 67, 171, 28);
		
		passwordTextField=new JTextField();
		passwordTextField.setBounds(227, 107, 171, 28);
		
		frmChartlogin.getContentPane().add(nameTextField);
		frmChartlogin.getContentPane().add(passwordTextField);
		nameTextField.setColumns(10);
		passwordTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("enter username:");
		lblNewLabel.setBounds(57, 66, 128, 28);
		frmChartlogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabe2 = new JLabel("enter userpassword:");
		lblNewLabe2.setBounds(57, 106, 128, 28);
		frmChartlogin.getContentPane().add(lblNewLabe2);
		
		try {
			socket=new Socket("127.0.0.1", 2222);
			pWrite=new PrintWriter(socket.getOutputStream());
			bReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				String strName=nameTextField.getText();
				String strPassword=passwordTextField.getText();
				try {
					System.out.println(strName+"  "+strPassword);
					pWrite.println(strName+":"+strPassword);
					pWrite.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				new GetMsgFromServer().start();
				
			}
		});
		btnNewButton.setBounds(126, 153, 144, 37);
		frmChartlogin.getContentPane().add(btnNewButton);
	}
	
	
	class GetMsgFromServer extends Thread{

		@Override
		public void run() {
			while(this.isAlive()) {
			try {
				
				String strMsg=bReader.readLine();
				if(strMsg.equals("true")) {
					
				JOptionPane.showMessageDialog(null, "µÇÂ½³É¹¦£¡£¡", "info:", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
					JOptionPane.showMessageDialog(null, "µÇÂ½Ê§°Ü£¡£¡", "info:", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
		
		
		
	}
	
}
