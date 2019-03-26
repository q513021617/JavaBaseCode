package class04;

import java.io.Serializable;
import java.sql.Date;

public class Log implements Serializable{

	private Integer id;
	private String date;
	private String local;
	private int status;
	private String username;
	private String ip;
	private int type;
	
	public Log() {}

	public Log(Integer id, String date, String local, int status, String username, String ip, int type) {
		super();
		this.id = id;
		this.date = date;
		this.local = local;
		this.status = status;
		this.username = username;
		this.ip = ip;
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	
	
	
}
