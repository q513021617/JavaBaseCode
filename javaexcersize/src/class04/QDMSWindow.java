package class04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import class04.AddtransportWin;
import class04.LogTable;
import class04.addlogWin;

import javax.swing.JScrollPane;

public class QDMSWindow {

	private JFrame frmQdms;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QDMSWindow window = new QDMSWindow();
					window.frmQdms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QDMSWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQdms = new JFrame();
		frmQdms.setTitle("Q-DMS\u7CFB\u7EDF\u5BA2\u6237\u7AEF");
		frmQdms.setBounds(100, 100, 544, 391);
		frmQdms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmQdms.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u64CD\u4F5C");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u63D2\u5165\u65E5\u5FD7");
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_1);
		frmQdms.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 23);
		frmQdms.getContentPane().add(toolBar);
		
		JButton button = new JButton("\u91C7\u96C6\u6570\u636E");
		toolBar.add(button);
		
		JButton button_1 = new JButton("\u5339\u914D\u65E5\u5FD7\u6570\u636E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LogTable logTable=new LogTable();
				
			}
		});
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("\u5339\u914D\u7269\u6D41\u6570\u636E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				transportTable tr=new transportTable();
			}
		});
		toolBar.add(button_2);
		
		JButton button_3 = new JButton("\u4FDD\u5B58\u6570\u636E");
		toolBar.add(button_3);
		
		JButton button_4 = new JButton("\u53D1\u9001\u6570\u636E");
		toolBar.add(button_4);
		
		JButton button_5 = new JButton("\u663E\u793A\u6570\u636E");
		toolBar.add(button_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 424, 23);
		frmQdms.getContentPane().add(panel);
		JPanel panel_show = new JPanel();
		JButton btnNewButton = new JButton("\u65E5\u5FD7");
		
		
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(btnNewButton);
		
		JButton button_6 = new JButton("\u7269\u6D41\u6570\u636E");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddtransportWin an=new AddtransportWin();
			}
		});
		panel.add(button_6);
		
		
		panel_show.setBounds(10, 66, 424, 162);
		frmQdms.getContentPane().add(panel_show);
		panel_show.setLayout(new CardLayout(0, 0));
		
		
		
		
		JScrollPane scrollPane_showData = new JScrollPane();
		panel_show.add(scrollPane_showData, "name_53915873812533");
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addlogWin logwin=new addlogWin();
//				panel_show.add(table_transport, "name_54239197858902");
//				panel_show.add(panel_transport, "name_50754127293812");
//				panel_show.revalidate();
//				panel_show.repaint();
			}
		});

		JButton button_11 = new JButton("\u786E\u8BA4");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});

		
		
		
		
//		String[] transportstatus=new String[] {"发货中","送货中","已签收"};
//		comTransportStatus=new JComboBox<String>(transportstatus);
//		panel_transport.add(comTransportStatus);
		
		
		
	}
}
