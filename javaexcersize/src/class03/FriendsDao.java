package class03;

import java.sql.SQLException;
import java.util.List;

public interface FriendsDao {

	

	public int getTotalCount() throws SQLException;
	
	public boolean insert(Friends friends) throws SQLException;

	public boolean delete(Friends chatContent) throws SQLException;

	
	public List<Friends> loadAll() throws SQLException;
	
	public List<Friends> searchByUserId(int id) throws SQLException;
	
	public Friends searchById(int id) throws SQLException;
}
