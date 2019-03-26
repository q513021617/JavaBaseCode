package class03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendsDaoImpl implements FriendsDao {
	BaseDAO baseDAO=new BaseDAO();

	@Override
	public int getTotalCount() throws SQLException {
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select count(id) from friends");
			if (res.next()) {
				return res.getInt(1);
			}
			}
			return 0;
	}

	@Override
	public boolean insert(Friends friends) throws SQLException {
		
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("insert into friends (userid,friend_id"
					+ ")values"+"('"+friends.getUserid()+"',"+ friends.getFriend_id()+")");
			return res>0;
			}
		return false;
	}

	@Override
	public boolean delete(Friends friends) throws SQLException {
		
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("DELETE FROM friends where"
					+ " id="+friends.getId()
					);
			return res>0;
			}
		return false;
	}

	@Override
	public List<Friends> loadAll() throws SQLException {
		
		List<Friends> friendss=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select * from friends");
			while (res.next()&&res!=null) {
				Friends friends=new Friends();
				friends.setId(res.getInt("id"));
				friends.setUserid(res.getInt("userid"));
				friends.setFriend_id(res.getInt("friend_id"));
	
				friendss.add(friends);
			}
			}
		return friendss;
	}

	@Override
	public Friends searchById(int id) throws SQLException {
		
		// TODO Auto-generated method stub
		Friends friends=new Friends();
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select id,userid,friend_id"
					+ "from friends where id="+String.valueOf(id));
			if (res.next()) {
				friends.setId(res.getInt("id"));
				friends.setUserid(res.getInt("userid"));;
				friends.setFriend_id(res.getInt("friend_id"));
				
			}
			}
		return friends;
	}

	@Override
	public List<Friends> searchByUserId(int id) throws SQLException {
		List<Friends> fList=new ArrayList<Friends>();
		
		
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select * from friends where userid="+String.valueOf(id));
			while (res.next()&&res!=null) {
				Friends friends=new Friends();
				friends.setId(res.getInt("id"));
				friends.setUserid(res.getInt("userid"));
				friends.setFriend_id(res.getInt("friend_id"));
	
				fList.add(friends);
			}
			}
		return fList;
	}

}
