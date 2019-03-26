package class04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LogTable {

	private JFrame frame;
	private JTable table_transport;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogTable window = new LogTable();
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
	public LogTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		table_transport = new JTable();
		table_transport.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u65E5\u5FD7\u7C7B\u522B", "IP", "\u7528\u6237\u540D", "\u72B6\u6001", "\u91C7\u96C6\u5730\u70B9", "\u91C7\u96C6\u65F6\u95F4", "id"
			}
		));
		table_transport.getColumnModel().getColumn(1).setPreferredWidth(97);
		
		
		frame.add(table_transport);
		frame.setVisible(true);
	}

}
