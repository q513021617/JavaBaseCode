package class03;

import java.sql.SQLException;
import java.util.List;

public interface ChatContentDao {

	
public int getTotalCount() throws SQLException;
	
	public boolean insert(ChatContent chatContent) throws SQLException;

	public boolean delete(ChatContent chatContent) throws SQLException;

	
	public List<ChatContent> loadAll() throws SQLException;
	

	
	public ChatContent searchById(int id) throws SQLException;

}
