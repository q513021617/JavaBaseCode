package class04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class TestConnet {
	public static void main(String[] args) throws SQLException {

	DaoHepler baseDAO=new DaoHepler();
	config config=new config();
	System.out.println(config.getResourceBundleCNValue("name"));
	System.out.println(config.getResourceBundleENValue("name"));
//	baseDAO.getConn();
	baseDAO.openAutoCommit();
	LogDao loDao=new logDaoIpml();
	
//	Integer id=1;
//	Date date=new Date();
//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String local="bendi" ;
//	int status=0;
//	String username="heello";
//	String ip="192.1.1.1";
//	int type=0;
//	String strdate=df.format(date);
//	Log log=new Log(id,strdate,local,status,username,ip,type);
//	loDao.add(log);
	
	
	
	
	
	
	
	TransportDao transportDao=new TransportDaoImpl();
	
	List<Transport> transports=new ArrayList<>();
	
	transports=transportDao.loadAll();
	for (Transport transport : transports) {
		System.out.println(transport.getBrokerageName());
	}
	
//	Date date=new Date();
//	java.text.SimpleDateFormat datestr=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//	System.out.println(datestr.format(date));
//	List<Transport> trans=new ArrayList<>();
//	
//	for (int i = 0; i < 10; i++) {
//	Transport transport=new Transport(200+i, Timestamp.valueOf(datestr.format(date)), "TTTTTcccc",0001, "hhhhh", "zzr", "物流公司", 0, 1);

//		trans.add(transport);
//	transportDao.add(transport);
	
//	}
	
//	Transport transport=new Transport(161, Timestamp.valueOf(datestr.format(date)), "TTTTTcccooooc",0001, "hhhhh", "zzr", "物流公9司", 0, 1);
//	
//	transportDao.update(transport);
	
//	System.out.println(transportDao.getTotalCount());
//	System.out.println(transportDao.insert(transport));
//	System.out.println(transportDao.insertAll(trans));
//	Transport transport=new Transport(147, Timestamp.valueOf(datestr.format(date)), "yoyo",00002, "hehe", "老李", "物流公司", 0, 1);
//	System.out.println(transportDao.update(transport));	//xiugai
	//System.out.println(transportDao.delete(transport));	//shanchu
//	System.out.println(transportDao.deleteById(transport.getTransportNum()));
//	trans=transportDao.loadAll(2,4);
	//trans=transportDao.searchByHandler("物流", false, 2, 3);
	
	
//	System.out.println(config.getValue("user"));
//	
//	Map<Integer, String> newobject=new HashMap<>();
//	Object[] objects=new Object[2];
//	objects[0]="描述";
//	objects[1]="小张";
//	LinkedHashMap<String, String> orderby =new LinkedHashMap<>();
//	orderby.put("transport_id", "desc");
//	trans=transportDao.search("destination= ? and sendPersonName=?", objects,orderby, 2, 3);
//	for (Transport transport1 : trans) {
//		System.out.println(transport1.getId()+" "+transport1.getBrokerageName());
//	}
//	
//	System.out.println(transportDao.searchById(3).getId());
	
	
	baseDAO.closeAutoCommit();
//	baseDAO.closeResultSet();
//	baseDAO.closeStatement();
//	baseDAO.closeConnection();
	System.out.println();
	}
}

