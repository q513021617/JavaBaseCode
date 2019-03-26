package class04;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class addlogWin {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	DaoHepler baseDAO=new DaoHepler();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addlogWin window = new addlogWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addlogWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JPanel panel_login = new JPanel();
//		panel_show.add(panel_login, "name_50706749249386");
		panel_login.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_3 = new JLabel("\u65E5\u5FD7id\uFF1A");
		panel_login.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(100, 20));
		textField_3.setColumns(10);
		panel_login.add(textField_3);
		
		JLabel label_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		panel_login.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_login.add(textField_4);
		
		JLabel label_5 = new JLabel("\u767B\u9646\u5730\u70B9\uFF1A");
		panel_login.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_login.add(textField_5);
		
		JLabel label_6 = new JLabel("\u767B\u9646IP:");
		panel_login.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_login.add(textField_6);
		
		JLabel label_7 = new JLabel("\u767B\u9646\u72B6\u6001\uFF1A");
		panel_login.add(label_7);
		
		JRadioButton radioButton = new JRadioButton("login");
		panel_login.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("loginout");
		panel_login.add(radioButton_1);
		
		JButton button_9 = new JButton("\u767B\u9646");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Log log=new Log();
				try {
					baseDAO.openAutoCommit();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.setId(Integer.parseInt(textField_3.getText()));
				
				String username=textField_4.getText();
				log.setUsername(username);
//				String loginlocal="";
				String local=textField_5.getText();
				log.setLocal(local);
				
				String ip=textField_6.getText();
				log.setIp(ip);
				
				Date date=new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				log.setDate(df.format(date));
				int loginstatus=0;
				
				if(radioButton.isSelected())
					loginstatus=1;
				log.setStatus(loginstatus);
				LogDao loDao=new logDaoIpml();
				loDao.add(log);
				try {
					baseDAO.closeAutoCommit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("add win");
				
			}
		});
		panel_login.add(button_9);
		
		JButton button_10 = new JButton("\u91CD\u7F6E");
		panel_login.add(button_10);
		
		
		
		frame.getContentPane().add(panel_login);
		
		
		
		frame.setVisible(true);
		
	}

}
