package class03;

import java.util.Date;

public class User {

	int id;
	String username;
	int say_Content_id;
	int friends;
	public User(int id, String username, int say_Content_id, int friends) {
		super();
		this.id = id;
		this.username = username;
		this.say_Content_id = say_Content_id;
		this.friends = friends;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSay_Content_id() {
		return say_Content_id;
	}
	public void setSay_Content_id(int say_Content_id) {
		this.say_Content_id = say_Content_id;
	}
	public int getFriends() {
		return friends;
	}
	public void setFriends(int friends) {
		this.friends = friends;
	}

	
	
	
	
	
}
