package class03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ChatContentDaoImpl implements ChatContentDao {
	BaseDAO baseDAO=new BaseDAO();
	public ChatContentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTotalCount() throws SQLException {
		
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select count(id) from chat_content");
			if (res.next()) {
				return res.getInt(1);
			}
			}
			return 0;
	}

	@Override
	public boolean insert(ChatContent chatContent) throws SQLException {
		
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("insert into chat_content (userid,content,time"
					+ ")values"+"("+String.valueOf(chatContent.getUserid())+",'"+ chatContent.getContent()+"','"+chatContent.getTime()+"')");
			return res>0;
			}
		return false;
	}

	@Override
	public boolean delete(ChatContent chatContent) throws SQLException {
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("DELETE FROM chat_content where"
					+ " id="+chatContent.getId()
					);
			return res>0;
			}
		return false;
	}

	@Override
	public List<ChatContent> loadAll() throws SQLException {
		
		List<ChatContent> ChatContents=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select * from chat_content");
			while (res.next()&&res!=null) {
				ChatContent chatContent=new ChatContent();
				chatContent.setId(res.getInt("id"));
				chatContent.setUserid(res.getInt("userid"));
				chatContent.setContent(res.getString("content"));
				chatContent.setTime(res.getString("time"));
				ChatContents.add(chatContent);
			}
			}
		return ChatContents;
	}

	@Override
	public ChatContent searchById(int id) throws SQLException {
		ChatContent chatContent=new ChatContent();
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select id,userid,friend_id"
					+ "from friends where id="+String.valueOf(id));
			if (res.next()) {
				chatContent.setId(res.getInt("id"));
				chatContent.setUserid(res.getInt("userid"));
				chatContent.setContent(res.getString("content"));
				chatContent.setTime(res.getString("time"));
				
			}
			}
		return chatContent;
	}

}
