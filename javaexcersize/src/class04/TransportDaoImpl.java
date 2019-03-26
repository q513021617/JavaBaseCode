package class04;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.mysql.jdbc.Statement;


public class TransportDaoImpl extends BaseDaoImpl<Transport> implements TransportDao {

	
	private Class<?> EntityClass;

    private String sql;

    private PreparedStatement statement;
    private List<Transport> list;
    
    private ResultSet rs;
	
	
	DaoHepler baseDAO=new DaoHepler();
	
	
	
	
	
	
	public TransportDaoImpl() {
		
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		
        EntityClass = (Class<?>) type.getActualTypeArguments()[0];
	
	}

	
	@Override
	public int getTotalCount() throws SQLException {
		if(baseDAO.getConn()!=null) {
		 statement= baseDAO.getPreparedStatement("select count(transport_id) from transport");
		rs=statement.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		}
		return 0;
	}

//	@Override
//	public boolean insert(Transport transport) throws SQLException {
//		// TODO Auto-generated method stub
////		
////		+;
//		if(baseDAO.getConn()!=null) {
//			statement=baseDAO.getPreparedStatement("insert into transport (time,destination,sendPersonName,receivePersonName"
//					+ ",brokerageName,type,status,transportNum)values"+"('"+transport.getTime()+"','"+ transport.getDestination()+"','" +transport.getSendPersonName()+
//					"','"+transport.getReceivePersonName()+"','" +transport.getBrokerageName()+"'," +transport.getType()+"," +transport.getStatus()+","+transport.getTransportNum()+")");
//			
//			boolean rs=statement.execute();
//			return rs;
//			}
//		return false;
//		
//	}


//	@Override
//	public boolean insertAll(List<Transport> transports) throws SQLException {
//		// TODO Auto-generated method stub
//		int successCount=0;
//		for (Transport transport : transports) {
//			if(insert(transport)) successCount++;
//		}
//		return successCount>0;
//	}

//	@Override
//	public boolean update(Transport transport) {
//		// TODO Auto-generated method stub
//		if(baseDAO.getConn()!=null) {
//			boolean rs = false;
//			try {
//				statement = baseDAO.getPreparedStatement("update transport set time='"+transport.getTime()
//						+ "',destination='"+ transport.getDestination()
//						+ "',sendPersonName='"+transport.getSendPersonName()
//						+ "',receivePersonName='"+transport.getReceivePersonName()
//						+ "',brokerageName='"+transport.getBrokerageName()
//						+ "',type=" +transport.getType()
//						+ ",status=" +transport.getStatus()
//						+ ",transportNum=" +transport.getTransportNum()
//						+" where transport_id="+transport.getTransport_id()+";");
//				rs=statement.execute();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return rs;
//			}
//		return false;
//	}

//	@Override
//	public boolean updateAll(List<Transport> transports) throws SQLException {
//		// TODO Auto-generated method stub
//		int successCount=0;
//		for (Transport transport : transports) {
//			if(update(transport)) successCount++;
//		}
//		return successCount>0;
//	}

//	@Override
//	public boolean delete(Transport transport) throws SQLException {
//		// TODO Auto-generated method stub
//		boolean rs=false;
//		if(baseDAO.getConn()!=null) {
//			statement=baseDAO.getPreparedStatement("DELETE FROM transport where"
//					+ " transport_id="+transport.getTransport_id()
//					);
//			return rs;
//			}
//		return false;
//	}
//
//	@Override
//	public boolean deleteAll(List<Transport> transports) throws SQLException {
//		// TODO Auto-generated method stub
//			int successCount=0;
//			for (Transport transport : transports) {
//				if(delete(transport)) successCount++;
//			}
//			return successCount>0;
//	}
//
//	@Override
//	public boolean deleteById(int id) throws SQLException {
//		// TODO Auto-generated method stub
//		if(baseDAO.getConn()!=null) {
//			statement=baseDAO.getPreparedStatement("DELETE FROM transport where"
//					+ " transportNum="+id
//					);
//			boolean rs=statement.execute();
//			return rs;
//			}
//		return false;
//	}
//
//	@Override
//	public boolean deleteAllByIds(int[] ids) throws SQLException {
//		// TODO Auto-generated method stub
//		int successCount=0;
//		for (int id : ids) {
//			if(deleteById(id)) successCount++;
//		}
//		return successCount>0;
//	}

	@Override
	public List<Transport> loadAll() throws SQLException {
		List<Transport> transports=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			statement=baseDAO.getPreparedStatement("select * from transport");
			rs=statement.executeQuery();
			while (rs.next()&&rs!=null) {
				Transport transport=new Transport();
				transport.setBrokerageName(rs.getString("brokerageName"));
				transport.setDestination(rs.getString("destination"));
				transport.setId(rs.getInt("id"));
				transport.setReceivePersonName(rs.getString("receivePersonName"));
				transport.setSendPersonName(rs.getString("sendPersonName"));
				transport.setStatus(rs.getInt("status"));
				transport.setTime(rs.getDate("time"));
				transport.setTransportNum(rs.getInt("transportNum"));
				transport.setType(rs.getInt("type"));
				transports.add(transport);
			}
			}
		return transports;
	}

	@Override
	public List<Transport> loadAll(int page, int rows) throws SQLException {
		
		StringBuffer b = new StringBuffer();
		
		if(page==-1||rows==-1)
			return loadAll();
		int count=getTotalCount();
//		12/6  2p
		
		List<Transport> transports=new ArrayList<>();
		sql = b.append("select transport_id,time,destination,sendPersonName,receivePersonName\"\r\n" + 
				"					+ \",brokerageName,type,status,transportNum from " + EntityClass.getSimpleName()+" limit "+(page-1)*rows+","+rows)
                .toString();
		
		if(baseDAO.getConn()!=null) {
			statement=baseDAO.getPreparedStatement(sql);
			rs=statement.executeQuery();
			while (rs.next()&&rs!=null) {
				Transport transport=new Transport();
				transport.setBrokerageName(rs.getString("brokerageName"));
				transport.setDestination(rs.getString("destination"));
				transport.setId(rs.getInt("id"));
				transport.setReceivePersonName(rs.getString("receivePersonName"));
				transport.setSendPersonName(rs.getString("sendPersonName"));
				transport.setStatus(rs.getInt("status"));
				transport.setTime(rs.getDate("time"));
				transport.setTransportNum(rs.getInt("transportNum"));
				transport.setType(rs.getInt("type"));
				transports.add(transport);
			}
			
			}
		return transports;
	}

//	@Override
//	public Transport searchById(int id) throws SQLException {
//		
//		
//		// TODO Auto-generated method stub
//		Transport transport=new Transport();
//		if(baseDAO.getConn()!=null) {
//			statement=baseDAO.getPreparedStatement("select transport_id,time,destination,sendPersonName,receivePersonName"
//					+ ",brokerageName,type,status,transportNum from transport where transport_id="+String.valueOf(id));
//			
//			rs=statement.executeQuery();
//			if (rs.next()) {
//				
//				transport.setBrokerageName(rs.getString("brokerageName"));
//				transport.setDestination(rs.getString("destination"));
//				transport.setTransport_id(rs.getInt("transport_id"));
//				transport.setReceivePersonName(rs.getString("receivePersonName"));
//				transport.setSendPersonName(rs.getString("sendPersonName"));
//				transport.setStatus(rs.getInt("status"));
//				transport.setTime(rs.getDate("time"));
//				transport.setTransportNum(rs.getInt("transportNum"));
//				transport.setType(rs.getInt("type"));
//			
//			}
//			}
//		return transport;
//
//	}

//	@Override
//	public List<Transport> searchByHandler(String handler, boolean isWildcard, int page, int rows) throws SQLException {
//		
//		Transport transport=new Transport();
//		
//		List<Transport> transports=new ArrayList<>();
//		if(baseDAO.getConn()!=null) {
//			
//			if(isWildcard) {
//				statement=baseDAO.getPreparedStatement("select transport_id,time,destination,sendPersonName,receivePersonName"
//			
//					+ ",brokerageName,type,status,transportNum from transport where brokerageName like '%"+handler+"%' limit "+(page-1)*rows+","+rows);
//			
//			rs=statement.executeQuery();
//			
//			}else{
//				statement=baseDAO.getPreparedStatement("select transport_id,time,destination,sendPersonName,receivePersonName"
//					+ ",brokerageName,type,status,transportNum from transport where brokerageName='"+handler+"' limit "+(page-1)*rows+","+rows);}
//			while (rs.next()&&rs!=null) {
//				
//				transport.setBrokerageName(rs.getString("brokerageName"));
//				transport.setDestination(rs.getString("destination"));
//				transport.setTransport_id(rs.getInt("transport_id"));
//				transport.setReceivePersonName(rs.getString("receivePersonName"));
//				transport.setSendPersonName(rs.getString("sendPersonName"));
//				transport.setStatus(rs.getInt("status"));
//				transport.setTime(rs.getDate("time"));
//				transport.setTransportNum(rs.getInt("transportNum"));
//				transport.setType(rs.getInt("type"));
//				transports.add(transport);
//			}
//			}
//		return transports;
//	}





//	@Override
//	public List<Transport> search(String where, Object[] params, LinkedHashMap<String, String> orderby, int page,
//			int rows) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public boolean deleteAll(List<Transport> transports) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}


//	@Override
//	public boolean deleteAllByIds(int[] ids) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}

	

	

}
