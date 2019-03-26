package class03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;


public class UserDaoImpl implements UserDao {

	BaseDAO baseDAO=new BaseDAO();
	
	@Override
	public int getTotalCount() throws SQLException {
		if(baseDAO.getConn()!=null) {
		ResultSet res=baseDAO.executeQuery("select count(id) from user");
		if (res.next()) {
			return res.getInt(1);
		}
		}
		return 0;
	}

	@Override
	public boolean insert(User user) throws SQLException {
		// TODO Auto-generated method stub

		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("insert into user (username,say_Content_id,friends"
					+ ")values"+"('"+user.getUsername()+"',"+ user.getSay_Content_id()+"," +user.getFriends()+")");
			return res>0;
			}
		return false;
		
	}



	@Override
	public boolean delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("DELETE FROM user where"
					+ " id="+user.getId()
					);
			return res>0;
			}
		return false;
	}

	



	@Override
	public List<User> loadAll() throws SQLException {
		List<User> users=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select * from user");
			while (res.next()&&res!=null) {
				User user=new User();
				user.setId(res.getInt("id"));
				user.setUsername(res.getString("username"));
				user.setFriends(res.getInt("friends"));
				user.setSay_Content_id(res.getInt("say_Content_id"));
				users.add(user);
			}
			}
		return users;
	}



	@Override
	public User searchById(int id) throws SQLException {
		
		
		// TODO Auto-generated method stub
		User user=new User();
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select *"
					+ "from user where id="+String.valueOf(id));
			if (res.next()) {
				user.setId(res.getInt("id"));
				user.setUsername(res.getString("username"));;
				user.setSay_Content_id(res.getInt("say_Content_id"));
				
				user.setFriends(res.getInt("friends"));
		
			
			}
			}
		return user;

	}



}
