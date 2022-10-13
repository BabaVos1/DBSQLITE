package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_con {
	
	
	private static final String db_name = "user.db"; 
	private static final String path = "\\C:\\Users\\ahmed.almustafa\\eclipse-workspace\\DBSQLite\\";
	private static final String db_con = "jdbc:sqlite:" + path + db_name;
	
	
	public Connection getconnection() throws SQLException {
		
		 String url = db_con;
		
		Connection con = null;
		con = DriverManager.getConnection(url);
		
		return con;
	}
}
