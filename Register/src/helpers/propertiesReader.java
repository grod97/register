package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class propertiesReader {
public Connection con;
	
	private static propertiesReader propr = null;
	
	public Properties getFile(String url) {
		FileInputStream profile = null;
		Properties prop = null;
		try {
			profile = new FileInputStream(url);
			prop = new Properties();
			prop.load(profile);
			profile.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.toString());
		return prop;
	}
	public static synchronized propertiesReader getInstance () {
		
		return propr = ((propr == null) ? propr = new propertiesReader() : propr);
	}
	
	public Object getValue2(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getValue(String string, Object[] obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
