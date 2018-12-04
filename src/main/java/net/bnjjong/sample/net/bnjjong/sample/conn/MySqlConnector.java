package net.bnjjong.sample.net.bnjjong.sample.conn;

import net.bnjjong.sample.properties.PropertyHandler;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by bnjjong on 2018-12-03.
 */
public class MySqlConnector {

	private static Connection conn = null;

	private MySqlConnector(){}

	public static Connection getConnection(){
		if(conn == null){
			String driver = PropertyHandler.getInstance().getProperties().getString("db.maria1.driver");
			String url = PropertyHandler.getInstance().getProperties().getString("db.maria1.url");
			String id = PropertyHandler.getInstance().getProperties().getString("db.maria1.id");
			String pwd = PropertyHandler.getInstance().getProperties().getString("db.maria1.password");
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url,id,pwd);
			}
			catch (Exception e) {
				e.getStackTrace();
			}
		}
		return conn;
	}

	public static void close(){
		if(conn== null) return;
		try {
			if(!conn.isClosed()) conn.close();
		}
		catch (Exception e) {
			e.toString();
		}
		conn = null;
	}
}
