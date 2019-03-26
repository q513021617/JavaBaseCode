package class04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddtransportWin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	DaoHepler baseDAO=new DaoHepler();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddtransportWin window = new AddtransportWin();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AddtransportWin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JPanel panel_transport = new JPanel();
//		panel_show.add(panel_transport, "name_50754127293812");
		
		JLabel lblid = new JLabel("\u7269\u6D41ID:");
		panel_transport.add(lblid);
		
		textField = new JTextField();
		panel_transport.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u76EE\u7684\u5730\uFF1A");
		panel_transport.add(label);
		
		textField_1 = new JTextField();
		panel_transport.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7ECF\u624B\u4EBA\uFF1A");
		panel_transport.add(label_1);
		
		textField_2 = new JTextField();
		panel_transport.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7269\u6D41\u72B6\u6001\uFF1A");
		panel_transport.add(label_2);
		
		JRadioButton radioButton_2 = new JRadioButton("\u53D1\u8D27\u4E2D");
		panel_transport.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u9001\u8D27\u4E2D");
		panel_transport.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("\u5DF2\u7B7E\u6536");
		panel_transport.add(radioButton_4);
		
		JButton button_7 = new JButton("\u786E\u5B9A");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				id T
//				receivePersonName T1
//				sendPersonName T2
//				status R1
				try {
					baseDAO.openAutoCommit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TransportDao taTransportDao=new TransportDaoImpl();
				Transport transport=new Transport();
				transport.setId(Integer.parseInt(textField.getText()));
				String local=textField_1.getText();
				transport.setReceivePersonName(local);
				String sendPersonName =textField_2.getText();
				transport.setSendPersonName(sendPersonName);
//				0 发货中 1送货中  2 已签收
				int status=0;
				if(radioButton_2.isSelected())
					status=0;
				if(radioButton_3.isSelected())
					status=1;
				if(radioButton_4.isSelected())
					status=2;
				transport.setStatus(status);
				taTransportDao.add(transport);
				try {
					baseDAO.closeAutoCommit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_transport.add(button_7);
		
		JButton button_8 = new JButton("\u91CD\u7F6E");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		panel_transport.add(button_8);
		
		
		frame.add(panel_transport);
		
		
		frame.setVisible(true);
	}

}
