package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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

	
	ServerSocket serverSocket;
	
	ArrayList<BufferedReader> bReaders=new ArrayList<BufferedReader>();
	
	ArrayList<PrintWriter> pWriters=new ArrayList<PrintWriter>();
	
	LinkedList<String> msglist=new LinkedList<String>();
	
	static Map<String,PrintWriter> storeInfo;
	ExecutorService exec;
	public ChatServer() {
		
		
		try {
			serverSocket=new ServerSocket(3888);
			storeInfo=new HashMap<String,PrintWriter>();
			exec=Executors.newCachedThreadPool();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Server running..................");
		
		
		
		
	}
	
	public void putIn(String key,PrintWriter value) {
		synchronized(this) {
			storeInfo.put(key, value);
		}
	}
	
	synchronized static void remove(String key) {
		storeInfo.remove(key);
		System.out.println("当前在线人数为:"+storeInfo.size());
	}
	
	synchronized static void sendToAll(String message) {
		for (PrintWriter out : storeInfo.values()) {
			out.println(message);
		}
		
	}
	
	
	synchronized static void sendToSomeone(String name,String message) {
		PrintWriter pw=storeInfo.get(name);
		if(pw!=null) {
			pw.println("私聊: "+message);
		}
	}
	
	public void start() {
		try {
			while(true) {
			System.out.println("等待客户端连接... ... ");
			Socket socket = serverSocket.accept();
 
			// 获取客户端的ip地址
			InetAddress address = socket.getInetAddress();
			System.out.println("客户端：“" + address.getHostAddress() + "”连接成功！ ");
			/*
			* 启动一个线程，由线程来处理客户端的请求，这样可以再次监听
			* 下一个客户端的连接
			*/
			exec.execute(new GetMsgFromClient(socket)); //通过线程池来分配线程
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


	}
	

	
	
	
	
	
	
class GetMsgFromClient implements Runnable{
	Socket socket;
	String name;
	BufferedReader bReader;
	public GetMsgFromClient(Socket socket) {
		System.out.println("进入 GetMsgFromClient");
		this.socket=socket;
		
	}
	
	private String getName() {
		
		try {
			BufferedReader bReader=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter ipw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			while(true) {
				String nameString=bReader.readLine();
				System.out.println(nameString);
				if((nameString.trim().length()==0)||storeInfo.containsKey(nameString)) {
					
					ipw.println("FAIL");
					
				}else {
					ipw.print("OK");
					return nameString;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		return name;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			/*
			* 通过客户端的Socket获取客户端的输出流
			* 用来将消息发送给客户端
			*/
			System.out.println("线程启动");
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			/*
			* 将客户昵称和其所说的内容存入共享集合HashMap中
			*/
			name = getName();
			System.out.println(name);
			putIn(name, pw);
			Thread.sleep(100);
			
			// 服务端通知所有客户端，某用户上线
			sendToAll("[系统通知] “" + name + "”已上线");
			
			/*
			* 通过客户端的Socket获取输入流
			* 读取客户端发送来的信息
			*/
			BufferedReader bReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String msgString = null;
			
			
			while((msgString = bReader.readLine()) != null) {
				System.out.println();
				// 检验是否为私聊（格式：@昵称：内容）
				if(msgString.startsWith("@")) {
					int index = msgString.indexOf(":");
					if(index >= 0) {
						System.out.println("进入私聊");
						//获取昵称
						String theName = msgString.substring(1, index);
						String info = msgString.substring(index+1, msgString.length());
						info =  name + "："+ info;
						//将私聊信息发送出去
						sendToSomeone(name, info);
						sendToSomeone(theName, info);
						continue;
					}
				}
				// 遍历所有输出流，将该客户端发送的信息转发给所有客户端
				System.out.println(name+"："+ msgString);
				sendToAll(name+"："+ msgString);
			}	
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			remove(name);
			// 通知所有客户端，某某客户已经下线
			sendToAll("[系统通知] "+name + "已经下线了。");
			
			if(socket!=null) {
				try {
					socket.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}	
		}
	}

	
	
	
	
	
	
}

public static void main(String[] args) {
	ChatServer cServer	=new ChatServer();
	cServer.start();
}
}


