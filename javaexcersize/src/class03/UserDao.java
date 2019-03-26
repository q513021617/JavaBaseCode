package class03;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface UserDao {

	
	
	public int getTotalCount() throws SQLException;
	
	public boolean insert(User user) throws SQLException;
	


	public boolean delete(User transport) throws SQLException;

	

	
	
	
	public List<User> loadAll() throws SQLException;
	
	
	public User searchById(int id) throws SQLException;

}
