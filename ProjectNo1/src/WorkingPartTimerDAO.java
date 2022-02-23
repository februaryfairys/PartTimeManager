import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WorkingPartTimerDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##ezen";
	String password = "ezen1234";
	private String query;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<PartTimerVo> list(String pname) {
		ArrayList<PartTimerVo> list = new ArrayList<PartTimerVo>();

		try {
			connDB();

			query =  "SELECT * from PARTTIMERS WHERE NAME in (SELECT NAME FROM WORKINGPARTTIMERS)";

			System.out.println(query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					String name = rs.getString("NAME");
					String pw = rs.getString("PW");
					String tel = rs.getString("TEL");
					String role = rs.getString("ROLE");

					PartTimerVo data = new PartTimerVo(name, pw, tel, role);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void connDB() {
		try {
			Class.forName(driver);
//			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
