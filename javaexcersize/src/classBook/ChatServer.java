package classBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.BufferUnderflowException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.plaf.synth.SynthSpinnerUI;



public class ChatServer {

	BufferedReader bReader;
	ServerSocket serverSocket;
	
	ArrayList<BufferedReader> bReaders=new ArrayList<BufferedReader>();

	
	ArrayList<PrintWriter> pWriters=new ArrayList<PrintWriter>();
	
	LinkedList<String> msglist=new LinkedList<String>();
	
	PrintWriter printWriter;
	

	public ChatServer() throws IOException {
		
		
		try {
			serverSocket=new ServerSocket(2222);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		new AcceptSocketThread().start();
		new SendMsgToClinet().start();
		
		System.out.println("Server running..................");
		
		
		
		
	}
	
	
	
	
class AcceptSocketThread extends Thread{
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			super.run();
			while(this.isAlive()) {
				
				try {
					Socket socket= serverSocket.accept();
					
					if(socket!=null) {
						
						BufferedReader bReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						bReaders.add(bReader);
						new GetMsgFromClient(bReader).start();
						pWriters.add(new PrintWriter(socket.getOutputStream()));
				
					}
					
					
			
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		
		}

	}
	
	


class SendMsgToClinet extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		
		while (this.isAlive()) {
			
			
			if (!msglist.isEmpty()) {
				String msg=msglist.removeLast();
				
				for (int i = 0; i < pWriters.size(); i++) {
					
					pWriters.get(i).println(msg);
					pWriters.get(i).flush();
				}
			}
			
			
		}
		
		
	}
	
	
	
	
}

class GetMsgFromClient extends Thread{
	
	BufferedReader bReader;
	User user=new User();
	UserDao userdao=new UserDaoImpl();
	String strPassword;
	String strName;
	public GetMsgFromClient(BufferedReader bReader) {
	this.bReader=bReader;
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		
			while(this.isAlive()) {
			try {
				String strMsg=bReader.readLine();
				if(strMsg!=null) {
					String[] strArr=strMsg.split(":");
					 strName=strArr[0];
					 strPassword=strArr[1];
					user=userdao.searchByName(strName);
				}
				
				
		
				// TODO Auto-generated catch block
			
				if(user.getPassword().equals(strPassword)) {
				
					msglist.add("true");
			}else {
				msglist.add("false");
			}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
	}
}	
	
	
	public static void main(String[] args) throws IOException {
		new ChatServer();
	}
	
	
	
	

}
