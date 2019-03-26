package class04;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface TransportDao extends BaseDaoT<Transport> {

	
	/**
	 * ͳ�����������¼����
	 * @return ���������¼
	 * @throws SQLException
	 */
	public int getTotalCount() throws SQLException;
	
//	public boolean insert(Transport transport) throws SQLException;
	
	
	
//	public boolean insertAll(List<Transport> transports)throws SQLException;
	
//	public boolean update(Transport transport);
	
//	public boolean updateAll(List<Transport> transports) throws SQLException;
	
	/**
	 * ��������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean delete(Transport transport) throws SQLException;
	/**
	 * ������������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAll(List<Transport> transports) throws SQLException;
	
	
	/**
	 * ��������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteById(int id) throws SQLException;
	/**
	 * ������������ɾ�����������¼
	 * @param transport
	 * @return 
	 * @throws SQLException
	 */
//	public boolean deleteAllByIds(int[] ids) throws SQLException;
	
	
	
	
	public List<Transport> loadAll() throws SQLException;
	
	/**
	 * ��ҵ��ѯ
	 * @param page ��ǰҳ�룬-1��ʾ����
	 * @param rows ÿҳ��¼����,-1��ʾ����
	 * @return
	 * @throws SQLException
	 */
	public List<Transport> loadAll(int page,int rows) throws SQLException;
	
	/**
	 * ����������ѯ
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
//	public Transport searchById(int id) throws SQLException;
	/**
	 * ���վ��������ֲ�ѯ��ҳ
	 * @param handler ����������
	 * @param isWildcard �Ƿ�ͨ��ͨ���ģ����ѯ
	 * @param page ��ǰҳ�룬-1��ʾ����
	 * @param rows ÿҳ��¼����,-1��ʾ����
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> searchByHandler(String handler,boolean isWildcard,int page,int rows) throws SQLException;
	
	/**
	 * ����where ����ִ�в�ѯ����ҳ
	 * @param where ������䣬����where�ؼ��֣��������ֻ�ܹ�ʹ��λ�ò�����λ�ò���������ֵ��1��ʼ���� o.username=?1 and o.password=?2
	 * @param params ���������ֵ�λ�ò���ֵ
	 * @param page ��ǰҳ�룬-1��ʾ����
	 * @param rows ÿҳ��¼����,-1��ʾ����
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> search(String where,Object[] params,int page,int rows) throws SQLException;
	
	/**
	 * ��������ѯ�����򲢷�ҳ
	 * @param where ������䣬����where�ؼ��֣��������ֻ�ܹ�ʹ��λ�ò�����λ�ò���������ֵ��1��ʼ���� o.username=?1 and o.password=?2
	 * @param params ���������ֵ�λ�ò���ֵ
	 * @param orderby ����,keyΪ�������ԣ�valueΪ asc/desc �磺
	 * LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
	 * orderby.put("email","asc");
	 *  orderby.put("passwrod","desc");
	 * @param page ��ǰҳ�룬-1��ʾ����
	 * @param rows ÿҳ��¼����,-1��ʾ����
	 * @return
	 * @throws SQLException
	 */
//	public List<Transport> search(String where,Object[] params,LinkedHashMap<String, String> orderby,int page,int rows) throws SQLException;
}
