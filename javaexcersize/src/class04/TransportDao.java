package class04;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface TransportDao extends BaseDaoT<Transport> {

	
	/**
	 * 统计物流运输记录条数
	 * @return 物流运输记录
	 * @throws SQLException
	 */
	public int getTotalCount() throws SQLException;
	
//	public boolean insert(Transport transport) throws SQLException;
	
	
	
//	public boolean insertAll(List<Transport> transports)throws SQLException;
	
//	public boolean update(Transport transport);
	
//	public boolean updateAll(List<Transport> transports) throws SQLException;
	
	/**
	 * 根据主键删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean delete(Transport transport) throws SQLException;
	/**
	 * 根据主键批量删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAll(List<Transport> transports) throws SQLException;
	
	
	/**
	 * 根据主键删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteById(int id) throws SQLException;
	/**
	 * 根据主键批量删除物流运输记录
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAllByIds(int[] ids) throws SQLException;
	
	
	
	
	public List<Transport> loadAll() throws SQLException;
	
	/**
	 * 分业查询
	 * @param page 当前页码，-1表示所有
	 * @param rows 每页记录条数,-1表示所有
	 * @return
	 * @throws SQLException
	 */
	public List<Transport> loadAll(int page,int rows) throws SQLException;
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
//	public Transport searchById(int id) throws SQLException;
	/**
	 * 按照经手人名字查询分页
	 * @param handler 经手人姓名
	 * @param isWildcard 是否通过通配符模糊查询
	 * @param page 当前页码，-1表示所有
	 * @param rows 每页记录条数,-1表示所有
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> searchByHandler(String handler,boolean isWildcard,int page,int rows) throws SQLException;
	
	/**
	 * 构建where 条件执行查询并分页
	 * @param where 条件语句，不带where关键字，条件语句只能够使用位置参数，位置参数得索引值以1开始例如 o.username=?1 and o.password=?2
	 * @param params 条件语句出现得位置参数值
	 * @param page 当前页码，-1表示所有
	 * @param rows 每页记录条数,-1表示所有
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> search(String where,Object[] params,int page,int rows) throws SQLException;
	
	/**
	 * 按条件查询并排序并分页
	 * @param where 条件语句，不带where关键字，条件语句只能够使用位置参数，位置参数得索引值以1开始例如 o.username=?1 and o.password=?2
	 * @param params 条件语句出现得位置参数值
	 * @param orderby 排序,key为排序属性，value为 asc/desc 如：
	 * LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
	 * orderby.put("email","asc");
	 *  orderby.put("passwrod","desc");
	 * @param page 当前页码，-1表示所有
	 * @param rows 每页记录条数,-1表示所有
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> search(String where,Object[] params,LinkedHashMap<String, String> orderby,int page,int rows) throws SQLException;
}
