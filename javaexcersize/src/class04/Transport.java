package class04;

import java.io.Serializable;
import java.util.Date;

public class Transport implements Serializable{

	int id;
	Date time;
	String destination;
	int transportNum;
	String sendPersonName;
	String receivePersonName;
	
	//����������
	String brokerageName;
	
	//��������,0 ���ˣ�1 ����
	int type;
	
	//����״̬ 0 �Խ��ܣ�1δ����
	int status;
	
	
	
	
	
	
	public Transport() {
		
	}


	public Transport(int id, Date time, String destination, int transportNum, String sendPersonName,
			String receivePersonName, String brokerageName, int type, int status) {
		super();
		this.id = id;
		this.time = time;
		this.destination = destination;
		this.transportNum = transportNum;
		this.sendPersonName = sendPersonName;
		this.receivePersonName = receivePersonName;
		this.brokerageName = brokerageName;
		this.type = type;
		this.status = status;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getTime() {
		return time;
	}






	public void setTime(Date time) {
		this.time = time;
	}






	public String getDestination() {
		return destination;
	}






	public void setDestination(String destination) {
		this.destination = destination;
	}






	public int getTransportNum() {
		return transportNum;
	}






	public void setTransportNum(int transportNum) {
		this.transportNum = transportNum;
	}






	public String getSendPersonName() {
		return sendPersonName;
	}






	public void setSendPersonName(String sendPersonName) {
		this.sendPersonName = sendPersonName;
	}






	public String getReceivePersonName() {
		return receivePersonName;
	}






	public void setReceivePersonName(String receivePersonName) {
		this.receivePersonName = receivePersonName;
	}






	public String getBrokerageName() {
		return brokerageName;
	}






	public void setBrokerageName(String brokerageName) {
		this.brokerageName = brokerageName;
	}






	public int getType() {
		return type;
	}






	public void setType(int type) {
		this.type = type;
	}






	public int getStatus() {
		return status;
	}






	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
}
