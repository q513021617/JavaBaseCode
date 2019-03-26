package class03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class TestConnet {
	public static void main(String[] args) throws SQLException {

	BaseDAO baseDAO=new BaseDAO();
	baseDAO.openAutoCommit();
//	UserDao userDao=new UserDaoImpl();
	ChatContentDao chatContentDao=new ChatContentDaoImpl();
	Date date=new Date();
	java.text.SimpleDateFormat datestr=new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String nowtime=datestr.format(date);
	System.out.println(nowtime);
//	List<User> trans=new ArrayList<>();
	
	for (int i = 0; i < 10; i++) {
	ChatContent ch=new ChatContent(i,i,"",datestr.format(date));
			
	chatContentDao.insert(ch);

	}
//	Friends fre=new Friends(i,i,i);
//	friendsDao.delete(fre);
//	System.out.println(friendsDao.getTotalCount());
//	List<Friends> friends=friendsDao.loadAll();
//	for (Friends f : friends) {
//		System.out.println(f.id);
//		System.out.println(f.userid);
//	}
//	System.out.println(transportDao.getTotalCount());
//	System.out.println(transportDao.insert(transport));
//	System.out.println(transportDao.insertAll(trans));
//	User transport=new User(64, Timestamp.valueOf(datestr.format(date)), "周",00002, "小赵", "老李", "物流公司", 0, 1);
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
	baseDAO.closeResultSet();
	baseDAO.closeStatement();
	baseDAO.closeConnection();
	System.out.println("wan cheng !!");
	}
}

