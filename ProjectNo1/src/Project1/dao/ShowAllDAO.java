package Project1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Project1.dto.PartTimerVo;

public class ShowAllDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##ezen";
	String password = "ezen1234";
	private String query;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<PartTimerVo> list() {
		ArrayList<PartTimerVo> list = new ArrayList<PartTimerVo>();

		try {
			connDB();

			query = "SELECT * from PARTTIMERS ORDER BY ROLE, NAME";

			System.out.println(query);
			rs = stmt.executeQuery(query);
			rs.first();
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
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
