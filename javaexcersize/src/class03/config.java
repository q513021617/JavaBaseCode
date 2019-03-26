package class03;

import java.io.FileInputStream;
import java.util.Properties;

public class config {

	private static Properties p=null;
	static {
		
		try {
			p=new Properties();
			p.load(new FileInputStream("src\\class03\\mysql.properties"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static String getValue(String key) {
		return p.get(key).toString();
		
	}

}
