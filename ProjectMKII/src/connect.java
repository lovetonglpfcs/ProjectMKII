import java.sql.Connection;
import java.sql.DriverManager;
public class connect {
	public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/car?serverTimezone=UTC";
			Connection con = DriverManager.getConnection(url,"root","21930") ;
			return con;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
