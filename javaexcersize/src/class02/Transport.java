package class02;

import java.util.Date;

public class Transport {

	int id;
	Date time;
	String destination;
	int TransportNum;
	String sendPersonName;
	String receivePersonName;
	//经手人名字
	String brokerageName;
	//物流类型,0 空运，1 航运
	int type;
	//物流状态 0 以接受，1未接收
	int status;

	public Transport(int id, Date time, String destination, int transportNum, String sendPersonName,
			String receivePersonName, String brokerageName, int type, int status) {
		super();
		this.id = id;
		this.time = time;
		this.destination = destination;
		TransportNum = transportNum;
		this.sendPersonName = sendPersonName;
		this.receivePersonName = receivePersonName;
		this.brokerageName = brokerageName;
		this.type = type;
		this.status = status;
	}
	public int getTransportNum() {
		return TransportNum;
	}
	public void setTransportNum(int transportNum) {
		TransportNum = transportNum;
	}
	public Transport() {
		// TODO Auto-generated constructor stub
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
	
	
	
	
	
}
