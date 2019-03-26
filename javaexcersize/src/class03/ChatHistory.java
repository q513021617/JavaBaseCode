package class03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextArea;

public class ChatHistory extends JFrame{


	/**
	 * Launch the application.
	 */
	
	ChatContent chatContent=new ChatContent();
	ChatContentDao chatContentDao=new ChatContentDaoImpl();
	UserDao userDao=new UserDaoImpl();
	/**
	 * Create the application.
	 */
	public ChatHistory(int id) {
		initialize(id);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		JFrame mainFrame=new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 33, 414, 218);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 23);
		getContentPane().add(menuBar);
		
		JMenu chatMenu = new JMenu("\u804A\u5929\u83DC\u5355");
		JMenuItem item1 = new JMenuItem("聊天历史纪录");
		
		JMenuItem item2 = new JMenuItem("聊天首页");
		chatMenu.add(item1);
		chatMenu.add(item2);
		menuBar.add(chatMenu);
		try {
			for (ChatContent chContent : chatContentDao.loadAll()) {
				textArea.append(userDao.searchById(chContent.getUserid()).username+": "+chContent.getContent()+"\n");;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					new client(id);
					mainFrame.setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		mainFrame.getContentPane().add(textArea);
		mainFrame.setVisible(true);
	}

}
