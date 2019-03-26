package class03;

import java.util.Date;

public class ChatContent {

	int id;
	int userid;
	String content;
	String time;
	public ChatContent() {
		// TODO Auto-generated constructor stub
	}
	public ChatContent(int id, int userid, String content, String time) {
		super();
		this.id = id;
		this.userid = userid;
		this.content = content;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	
	
	
}
