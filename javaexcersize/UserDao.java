package class03;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface UserDao {

	
	
	public int getTotalCount() throws SQLException;
	
	public boolean insert(User user) throws SQLException;
	
//	public boolean insertAll(List<User> users)throws SQLException;
	
//	public boolean update(User user) throws SQLException;
	
//	public boolean updateAll(List<User> transports) throws SQLException;
	
	/**
	 * 根据主键删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
	public boolean delete(User transport) throws SQLException;

	
//	public boolean deleteAll(List<User> transports) throws SQLException;
	
	
	
//	public boolean deleteById(int id) throws SQLException;
	/**
	 * 根据主键批量删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAllByIds(int[] ids) throws SQLException;
	
	
	
	
	public List<User> loadAll() throws SQLException;
	
	/**
	 * 分业查询
	 * @param page 当前页码，-1表示所有
	 * @param rows 每页记录条数,-1表示所有
	 * @return
	 * @throws SQLException
	 */
//	public List<User> loadAll(int page,int rows) throws SQLException;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
	public User searchById(int id) throws SQLException;

//	public List<User> searchByHandler(String handler,boolean isWildcard,int page,int rows) throws SQLException;
	
//	public List<User> search(String where,Object[] params,int page,int rows) throws SQLException;
	
	
//	public List<User> search(String where,Object[] params,LinkedHashMap<String, String> orderby,int page,int rows) throws SQLException;
}
