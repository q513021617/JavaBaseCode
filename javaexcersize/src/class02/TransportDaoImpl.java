package class02;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;


public class TransportDaoImpl implements TransportDao {

	BaseDAO baseDAO=new BaseDAO();
	
	@Override
	public int getTotalCount() throws SQLException {
		if(baseDAO.getConn()!=null) {
		ResultSet res=baseDAO.executeQuery("select count(transport_id) from transport");
		if (res.next()) {
			return res.getInt(1);
		}
		}
		return 0;
	}

	@Override
	public boolean insert(Transport transport) throws SQLException {
		// TODO Auto-generated method stub
//		
//		+;
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("insert into transport (time,destination,sendPersonName,receivePersonName"
					+ ",brokerageName,type,status,transportNum)values"+"('"+transport.getTime()+"','"+ transport.getDestination()+"','" +transport.getSendPersonName()+
					"','"+transport.getReceivePersonName()+"','" +transport.getBrokerageName()+"'," +transport.getType()+"," +transport.getStatus()+","+transport.getTransportNum()+")");
			return res>0;
			}
		return false;
		
	}

//	+"where transport_id="+transport.getId()
	@Override
	public boolean insertAll(List<Transport> transports) throws SQLException {
		// TODO Auto-generated method stub
		int successCount=0;
		for (Transport transport : transports) {
			if(insert(transport)) successCount++;
		}
		return successCount>0;
	}

	@Override
	public boolean update(Transport transport) throws SQLException {
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("update transport set time='"+transport.getTime()
					+ "',destination='"+ transport.getDestination()
					+ "',sendPersonName='"+transport.getSendPersonName()
					+ "',receivePersonName='"+transport.getReceivePersonName()
					+ "',brokerageName='"+transport.getBrokerageName()
					+ "',type=" +transport.getType()
					+ ",status=" +transport.getStatus()
					+ ",transportNum=" +transport.getTransportNum()
					+" where transport_id="+transport.getId()+";");
			return res>0;
			}
		return false;
	}

	@Override
	public boolean updateAll(List<Transport> transports) throws SQLException {
		// TODO Auto-generated method stub
		int successCount=0;
		for (Transport transport : transports) {
			if(update(transport)) successCount++;
		}
		return successCount>0;
	}

	@Override
	public boolean delete(Transport transport) throws SQLException {
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("DELETE FROM transport where"
					+ " transport_id="+transport.getId()
					);
			return res>0;
			}
		return false;
	}

	@Override
	public boolean deleteAll(List<Transport> transports) throws SQLException {
		// TODO Auto-generated method stub
			int successCount=0;
			for (Transport transport : transports) {
				if(delete(transport)) successCount++;
			}
			return successCount>0;
	}

	@Override
	public boolean deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			int res=baseDAO.executeUpdate("DELETE FROM transport where"
					+ " transportNum="+id
					);
			return res>0;
			}
		return false;
	}

	@Override
	public boolean deleteAllByIds(int[] ids) throws SQLException {
		// TODO Auto-generated method stub
		int successCount=0;
		for (int id : ids) {
			if(deleteById(id)) successCount++;
		}
		return successCount>0;
	}

	@Override
	public List<Transport> loadAll() throws SQLException {
		List<Transport> transports=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					+ ",brokerageName,type,status,transportNum from transport");
			while (res.next()&&res!=null) {
				Transport transport=new Transport();
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
				transports.add(transport);
			}
			}
		return transports;
	}

	@Override
	public List<Transport> loadAll(int page, int rows) throws SQLException {
		if(page==-1||rows==-1)
			return loadAll();
		int count=getTotalCount();
//		12/6  2p
		
		List<Transport> transports=new ArrayList<>();
		// TODO Auto-generated method stub
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					+ ",brokerageName,type,status,transportNum from transport limit "+(page-1)*rows+","+rows);
			while (res.next()&&res!=null) {
				Transport transport=new Transport();
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
				transports.add(transport);
			}
			}
		return transports;
	}

	@Override
	public Transport searchById(int id) throws SQLException {
		
		
		// TODO Auto-generated method stub
		Transport transport=new Transport();
		if(baseDAO.getConn()!=null) {
			ResultSet res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					+ ",brokerageName,type,status,transportNum from transport where transport_id="+String.valueOf(id));
			if (res.next()) {
				
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
			
			}
			}
		return transport;

	}

	@Override
	public List<Transport> searchByHandler(String handler, boolean isWildcard, int page, int rows) throws SQLException {
		
		Transport transport=new Transport();
		ResultSet res;
		List<Transport> transports=new ArrayList<>();
		if(baseDAO.getConn()!=null) {
			
			if(isWildcard) {
				res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
			
					+ ",brokerageName,type,status,transportNum from transport where brokerageName like '%"+handler+"%' limit "+(page-1)*rows+","+rows);
			}else{
			res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					+ ",brokerageName,type,status,transportNum from transport where brokerageName='"+handler+"' limit "+(page-1)*rows+","+rows);}
			while (res.next()&&res!=null) {
				
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
				transports.add(transport);
			}
			}
		return transports;
	}

	@Override
	public List<Transport> search(String where, Object[] params, int page, int rows) throws SQLException {
		// TODO Auto-generated method stub
		Transport transport=new Transport();
		ResultSet res;
		List<Transport> transports=new ArrayList<>();
		if(baseDAO.getConn()!=null) {
			res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					
					+ ",brokerageName,type,status,transportNum from transport where "+where+" limit "+(page-1)*rows+","+rows,params);
				while (res.next()&&res!=null) {
				
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
				transports.add(transport);
			}
		}
		
		
		return transports;
	}

	@Override
	public List<Transport> search(String where, Object[] params, LinkedHashMap<String, String> orderby, int page,
			int rows) throws SQLException {
		// TODO Auto-generated method stub
		Transport transport=new Transport();
		ResultSet res;
		List<Transport> transports=new ArrayList<>();
		String key="";
		String value="";
		String orderStrs="";
		if(baseDAO.getConn()!=null) {
			
			for (Entry<String,String> entry : orderby.entrySet()) {
				
				key=entry.getKey();
				value=entry.getValue();
				orderStrs+=" order by "+key+" "+value;
			}
			res=baseDAO.executeQuery("select transport_id,time,destination,sendPersonName,receivePersonName"
					
					+ ",brokerageName,type,status,transportNum from transport where "+where+orderStrs+" limit "+(page-1)*rows+","+rows,params);
			while (res.next()&&res!=null) {
				
				transport.setBrokerageName(res.getString("brokerageName"));
				transport.setDestination(res.getString("destination"));
				transport.setId(res.getInt("transport_id"));
				transport.setReceivePersonName(res.getString("receivePersonName"));
				transport.setSendPersonName(res.getString("sendPersonName"));
				transport.setStatus(res.getInt("status"));
				transport.setTime(res.getDate("time"));
				transport.setTransportNum(res.getInt("transportNum"));
				transport.setType(res.getInt("type"));
				transports.add(transport);
			}
		}
		
		
		return transports;
	}

}
