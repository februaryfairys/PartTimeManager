import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##ezen";
	String password = "ezen1234";
	String sql;

	public void addDAO(String name, String pw, String tel, String role) {
		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			sql = "insert into PARTTIMERS VALUES ('" + name + "','" + pw + "','" + tel + "' , '"
					+ role + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("INSERT SUCCSESS.\n");
			} else {
				System.out.println("INSERT FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
