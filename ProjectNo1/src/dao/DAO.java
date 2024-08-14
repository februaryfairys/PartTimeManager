package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##ezen";
	private String password = "ezen1234";
	private String PASSWORD = "0";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}

	public void add(String NAME, String PW, String TEL, String ROLE) {

		try {
			connDB();

			String sql;
			sql = "insert into PARTTIMERS VALUES ('" + NAME + "','" + PW + "','" + TEL + "' , '" + ROLE + "')";

			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("INSERT SUCCSESS.\n");
			} else {
				System.out.println("INSERT FAIL.\n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void edit(String name, String sub, String val, String role) {

		try {
			connDB();

			String sql1, sql2, sql3;
			String v1 = "NAME";

			if (sub.equals("����ó")) {
				v1 = "TEL";
			}

			sql1 = "update PARTTIMERS set " + v1 + " = '" + val + "' where NAME = '" + name + "'";
			sql2 = "update WORKINGPARTTIMERS set " + v1 + " = '" + val + "' where NAME = '" + name + "'";
			sql3 = "update WORKTIME set " + v1 + " = '" + val + "' where NAME = '" + name + "'";

			if (!(role.equals("�ƴϿ�"))) {
				sql1 = "update PARTTIMERS set " + v1 + "= '" + val + "', ROLE = '" + role + "' where NAME = '" + name
						+ "'";
			}
			boolean b;
			if (sub.equals("����ó")) {
				b = stmt.execute(sql1);
			} else {
				b = stmt.execute(sql1);
				stmt.execute(sql2);
				stmt.execute(sql3);
			}

			if (!b) {
				System.out.println("UPDATE SUCCSESS.\n");
			} else {
				System.out.println("UPDATE FAIL.\n");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void joinPassword(String key) {

		try {
			connDB();

			String sql = "SELECT * FROM PASSWORD WHERE PW = ('" + key + "')";
			rs = stmt.executeQuery(sql);
			rs.first();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					setPASSWORD(rs.getString("PW"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void reset() {
		try {
			connDB();
			String sql1, sql2, sql3, sql4;
			sql1 = "DELETE FROM PARTTIMERS";
			sql2 = "DELETE FROM WORKINGPARTTIMERS";
			sql3 = "DELETE FROM WORKTIME";
			sql4 = "UPDATE PASSWORD SET PW = '0000'";

			stmt.execute(sql1);
			stmt.execute(sql2);
			stmt.execute(sql3);
			stmt.execute(sql4);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
