package class04;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class config {

	private static Properties p=null;
	private static ResourceBundle resourceBundle=null;
	private static ResourceBundle resourceBundle2=null;
	private static ResourceBundle resourceBundle3=null;
	private static Locale localEn=new Locale("en", "US");
	private static Locale localzH=new Locale("zh", "CN");
	static {
		
		try {
			p=new Properties();
			
			p.load(new FileInputStream("src\\class02\\mysql.properties"));
			
			resourceBundle =ResourceBundle.getBundle("myres",Locale.getDefault());
			
			resourceBundle2 =ResourceBundle.getBundle("myres",localEn);
			resourceBundle3 =ResourceBundle.getBundle("myres",localzH);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static String getValue(String key) {
		return p.get(key).toString();
		
	}

	public static String getResourceBundleValue(String key) {
		return resourceBundle.getString(key);
		
	}
	
	public static String getResourceBundleENValue(String key) {
		return resourceBundle2.getString(key);
		
	}
	
	public static String getResourceBundleCNValue(String key) {
		return resourceBundle3.getString(key);
		
	}
}
