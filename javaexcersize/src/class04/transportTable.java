package class04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class transportTable {

	private JFrame frame;
	private JTable table;
	DaoHepler baseDAO=new DaoHepler();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transportTable window = new transportTable();
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
	public transportTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 414, 251);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		try {
			baseDAO.openAutoCommit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportDao transportDao=new TransportDaoImpl();
		
		List<Transport> transports=new ArrayList<>();
		try {
			transports=transportDao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] o=new Object[transports.size()][transports.get(0).toString().split(",").length];
		
		for (int i = 0; i < transports.size(); i++) {
			
			Transport transport=transports.get(i);
			o[i][0]=transport.getId();
			o[i][1]=transport.getReceivePersonName();
			o[i][2]=transport.getSendPersonName();
			o[i][3]=transport.getStatus();
		}

		
		
		
		
		table.setModel(new DefaultTableModel(
			o,
			new String[] {
				"\u7269\u6D41\u7C7B\u578B", "\u6536\u8D27\u4EBA", "\u7ECF\u624B\u4EBA", "\u72B6\u6001", "\u76EE\u7684\u5730", "\u91C7\u96C6\u65F6\u95F4", "\u7269\u6D41ID"
			}
		));
		panel.add(table);
		
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
}
