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
		System.out.println("��ǰ��������Ϊ:"+storeInfo.size());
	}
	
	synchronized static void sendToAll(String message) {
		for (PrintWriter out : storeInfo.values()) {
			out.println(message);
		}
		
	}
	
	
	synchronized static void sendToSomeone(String name,String message) {
		PrintWriter pw=storeInfo.get(name);
		if(pw!=null) {
			pw.println("˽��: "+message);
		}
	}
	
	public void start() {
		try {
			while(true) {
			System.out.println("�ȴ��ͻ�������... ... ");
			Socket socket = serverSocket.accept();
 
			// ��ȡ�ͻ��˵�ip��ַ
			InetAddress address = socket.getInetAddress();
			System.out.println("�ͻ��ˣ���" + address.getHostAddress() + "�����ӳɹ��� ");
			/*
			* ����һ���̣߳����߳�������ͻ��˵��������������ٴμ���
			* ��һ���ͻ��˵�����
			*/
			exec.execute(new GetMsgFromClient(socket)); //ͨ���̳߳��������߳�
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
		System.out.println("���� GetMsgFromClient");
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
			* ͨ���ͻ��˵�Socket��ȡ�ͻ��˵������
			* ��������Ϣ���͸��ͻ���
			*/
			System.out.println("�߳�����");
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			/*
			* ���ͻ��ǳƺ�����˵�����ݴ��빲����HashMap��
			*/
			name = getName();
			System.out.println(name);
			putIn(name, pw);
			Thread.sleep(100);
			
			// �����֪ͨ���пͻ��ˣ�ĳ�û�����
			sendToAll("[ϵͳ֪ͨ] ��" + name + "��������");
			
			/*
			* ͨ���ͻ��˵�Socket��ȡ������
			* ��ȡ�ͻ��˷���������Ϣ
			*/
			BufferedReader bReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String msgString = null;
			
			
			while((msgString = bReader.readLine()) != null) {
				System.out.println();
				// �����Ƿ�Ϊ˽�ģ���ʽ��@�ǳƣ����ݣ�
				if(msgString.startsWith("@")) {
					int index = msgString.indexOf(":");
					if(index >= 0) {
						System.out.println("����˽��");
						//��ȡ�ǳ�
						String theName = msgString.substring(1, index);
						String info = msgString.substring(index+1, msgString.length());
						info =  name + "��"+ info;
						//��˽����Ϣ���ͳ�ȥ
						sendToSomeone(name, info);
						sendToSomeone(theName, info);
						continue;
					}
				}
				// ������������������ÿͻ��˷��͵���Ϣת�������пͻ���
				System.out.println(name+"��"+ msgString);
				sendToAll(name+"��"+ msgString);
			}	
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			remove(name);
			// ֪ͨ���пͻ��ˣ�ĳĳ�ͻ��Ѿ�����
			sendToAll("[ϵͳ֪ͨ] "+name + "�Ѿ������ˡ�");
			
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


