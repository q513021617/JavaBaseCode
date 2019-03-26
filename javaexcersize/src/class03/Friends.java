package class03;

public class Friends {

	int id;
	int userid;
	int friend_id;
	
	public Friends() {
		// TODO Auto-generated constructor stub
	}
	public Friends(int id, int userid, int friend_id) {
		super();
		this.id = id;
		this.userid = userid;
		this.friend_id = friend_id;
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
	public int getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

}
