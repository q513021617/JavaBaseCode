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
	 * ��������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
	public boolean delete(User transport) throws SQLException;

	
//	public boolean deleteAll(List<User> transports) throws SQLException;
	
	
	
//	public boolean deleteById(int id) throws SQLException;
	/**
	 * ������������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAllByIds(int[] ids) throws SQLException;
	
	
	
	
	public List<User> loadAll() throws SQLException;
	
	/**
	 * ��ҵ��ѯ
	 * @param page ��ǰҳ�룬-1��ʾ����
	 * @param rows ÿҳ��¼����,-1��ʾ����
	 * @return
	 * @throws SQLException
	 */
//	public List<User> loadAll(int page,int rows) throws SQLException;
	
	/**
	 * ����������ѯ
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
	public User searchById(int id) throws SQLException;

//	public List<User> searchByHandler(String handler,boolean isWildcard,int page,int rows) throws SQLException;
	
//	public List<User> search(String where,Object[] params,int page,int rows) throws SQLException;
	
	
//	public List<User> search(String where,Object[] params,LinkedHashMap<String, String> orderby,int page,int rows) throws SQLException;
}
