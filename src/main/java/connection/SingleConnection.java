package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingleConnection {  
	
	public static String url = "jdbc:postgresql://localhost:5432/postgres";
	public static String user = "postgres";
	public static String pass = "admin";
	public static Connection conn = null;
	
	static {
		conectar();
	}
	
	public SingleConnection(){
		conectar();	
	}
	
	private static void conectar() {
		try {
			if(conn == null) {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}

}
