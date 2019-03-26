package class03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class client extends JFrame{

	static Socket socket;
	PrintWriter pWrite;
	BufferedReader bReader;
	JPanel panel;
	JScrollPane spannl;
	JLabel lblName,lblSend,lUsername;
	JTextField txtSend;
	String txtName;
	JButton btnSend;
	JList<String> friendlist = new JList<String>();
	JTextArea textContent = new JTextArea();
	User user=new User();
	UserDao userdao=new UserDaoImpl();
	FriendsDao friendsDao=new FriendsDaoImpl();
	private JScrollPane scrollPane;
	private JLabel lblFrendslist;
	private JButton addNewFriends;
	private JTextField newfriendsField;
	
	
	public void updateFriendsList() throws SQLException {
		
		List<Friends> friendsList=new ArrayList<Friends>();
		friendsList=friendsDao.searchByUserId(user.id);
		String[] strings=new String[10];
		int i=0;
		for (Friends friends : friendsList) {
			String temUsername=userdao.searchById(friends.getFriend_id()).username;
			
			strings[i]=temUsername;
			i++;
		}
//		panel.remove(scrollPane);
		scrollPane = new JScrollPane();
		
		panel.add(scrollPane);
		scrollPane.setBounds(0, 38, 66, 240);
		scrollPane.setViewportView(friendlist);
		
		lblFrendslist = new JLabel("frendsList");
		lblFrendslist.setBounds(0, 15, 60, 15);
//		panel.remove(lblFrendslist);
		panel.add(lblFrendslist);
		friendlist.setListData(strings);
	}
	
	
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public client(int id) throws SQLException {
		super("QST 聊天室");
		JFrame clientFrame=new JFrame();
		user=userdao.searchById(id);
		txtName=user.username;
		
		getContentPane().setLayout(null);
		
		
		panel=new JPanel();
		panel.setBounds(76, 184, 408, 77);
		panel.setLayout(null);
		
		
		lUsername=new JLabel(txtName);
		
		
		lUsername.setBounds(148, 205, 54, 15);
		panel.add(lUsername);
		txtSend=new JTextField(20);
		txtSend.setBounds(246, 202, 126, 21);
		panel.add(txtSend);
		lblSend=new JLabel("say:");
		lblSend.setBounds(212, 205, 24, 15);
		panel.add(lblSend);
		btnSend=new JButton("send");
		btnSend.setBounds(382, 201, 78, 23);
		panel.add(btnSend);
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String strName=txtName;
				String strMsg=txtSend.getText();
				
				if(!strMsg.equals("")) {
					
					pWrite.println(strMsg);
					ChatContentDao chatContentDao=new ChatContentDaoImpl();
					Date date=new Date();
					java.text.SimpleDateFormat datestr=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String nowtime=datestr.format(date);
					ChatContent chatContent=new ChatContent(0,user.getId(),strMsg,nowtime);
					try {
						chatContentDao.insert(chatContent);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pWrite.flush();
					txtSend.setText("");
				}
				
				
				
			}
		});
		
		friendlist.addListSelectionListener(
				new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						// TODO Auto-generated method stub
						System.out.println(friendlist.getSelectedValue());
					}
				}
				);
		
		addNewFriends = new JButton("addNewFriends");
		addNewFriends.setBounds(197, 229, 175, 23);
		addNewFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int friendsid=Integer.parseInt(newfriendsField.getText());
				Friends friends=new Friends(0,user.getId(),friendsid);
				try {
					
					if(friendsDao.insert(friends))
						{
						
						JOptionPane.showMessageDialog(null, "添加好友成功！","info:", JOptionPane.INFORMATION_MESSAGE);
						}
					newfriendsField.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		panel.add(addNewFriends);
		lblName=new JLabel("name:");
		lblName.setBounds(108, 205, 43, 15);
		panel.add(lblName);
		
		newfriendsField = new JTextField();
		newfriendsField.setBounds(121, 230, 66, 21);
		panel.add(newfriendsField);
		newfriendsField.setColumns(10);
		clientFrame.setSize(500,340);
		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		clientFrame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
			
			JMenu chatMenu = new JMenu("\u804A\u5929\u83DC\u5355");
			
			 JMenuItem item1 = new JMenuItem("聊天历史纪录");
			 item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new ChatHistory(user.getId());
				
			}
		});
			 
	     JMenuItem item2 = new JMenuItem("聊天主页");
	     
	     chatMenu.add(item1);
	     chatMenu.add(item2);
	     menuBar.add(chatMenu);
		clientFrame.getContentPane().add(panel);
		spannl=new JScrollPane();
		panel.add(spannl);
		spannl.setBounds(115, 10, 359, 169);
		spannl.setViewportView(textContent);
		
		try {
			socket=new Socket("127.0.0.1", 3888);
			
			pWrite=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			bReader=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pWrite.println(txtName);
		String pass = null;
		try {
			pass = bReader.readLine();
			System.out.println(pass);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(pass != null && (!pass.equals("OK"))&&pass.equals("FAIL")) {
			JOptionPane.showMessageDialog(null,"该用户已登陆" , "info:", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		clientFrame.setVisible(true);
		updateFriendsList();
		
		
		
		new GetMsgFromServer().start();
	}
	
class GetMsgFromServer extends Thread{
	
	
		
		public void run() {
			
			while(this.isAlive()) {
				
				try {
					String strMsg=bReader.readLine();
					
					if(strMsg!=null) {
						
						textContent.append(strMsg+"\n");
						
					}
					List<Friends> friendsList=new ArrayList<Friends>();
					try {
						friendsList=friendsDao.searchByUserId(user.id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					updateFriendsList();
					Thread.sleep(50);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
			}
			
			
		}
		
		
	}
}
