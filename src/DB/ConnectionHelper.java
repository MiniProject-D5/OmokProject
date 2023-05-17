package DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHelper {

	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosaDB",
							"cube",
							"oracle");
			}else if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"cube",
							"oracle");
				System.out.println("oracle connection success!!!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
	}
	
	public static Connection getConnection(String dsn, String userid, String pwd) {
		Connection conn = null;
		try {
			if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosaDB",
						userid,
						pwd);
			}else if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
						userid,
						pwd);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
	}
	
}
