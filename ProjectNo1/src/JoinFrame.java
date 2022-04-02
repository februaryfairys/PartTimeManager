

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JoinFrame extends AFrame {
	private Frame f;
	private TextField tf1, tf2;
	private Button b1;
	private Label lid, lpw;
	private JoinDAO dao = new JoinDAO();
	private AlreadyJoinedFrame ajf = new AlreadyJoinedFrame();
	private String name, password;

	public void start() {

		f = new Frame("Join");
		f.setSize(250, 240);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		lid = new Label("성명");
		lpw = new Label("직원번호");
		lid.setSize(50, 20);
		lpw.setSize(50, 20);
		lid.setLocation(35, 40);
		lpw.setLocation(35, 100);

		tf1 = new TextField();
		tf2 = new TextField();
		tf1.setSize(190, 20);
		tf2.setSize(190, 20);
		tf1.setLocation(30, 65);
		tf2.setLocation(30, 125);
		tf2.setEchoChar('●');

		b1 = new Button("출근하기");
		b1.setSize(160, 50);
		b1.setLocation(45, 160);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InputYourInfo iyi = new InputYourInfo();
				CheckNameOrPassword cnp = new CheckNameOrPassword();
				if (tf1.getText().equals("")) {
					iyi.start("name");
				} else if (tf2.getText().equals("")) {
					iyi.start("password");
				} else {
					ArrayList<VOPartTimer> list = dao.list(tf1.getText());
					if (list.size() == 0) {
						cnp.start();
					} else {
						VOPartTimer data = (VOPartTimer) list.get(0);
						String pswd = data.getPw();
						if (tf2.getText().equals(pswd)) {
							CheckJoinFrame chjf = new CheckJoinFrame();
							name = tf1.getText();
							password = tf2.getText();
							chjf.start(name, password);
							f.dispose();
						} else {
							cnp.start();
						}
					}
				}
			}
		});

		f.add(b1);
		f.add(tf1);
		f.add(tf2);
		f.add(lid);
		f.add(lpw);
		f.setVisible(true);
	}

	public void checkDAO(String name, String password) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String dbPassword = "ezen1234";
		String sql;

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, dbPassword);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			sql = "SELECT * FROM WORKINGPARTTIMERS WHERE NAME = '" + name + "' AND PW = '" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
				joinTimeDAO(name, password);
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				ajf.start();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void joinTimeDAO(String nm, String pw) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String dbPassword = "ezen1234";
		String sql, sql2, dt, joinTime;

		Date now = new Date();
		SimpleDateFormat sdfDt = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat sdfNow = new SimpleDateFormat("HHmm");

		try {

			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, dbPassword);
			System.out.println("oracle connection sucess.\n");
			Statement stmt = conn.createStatement();

			dt = sdfDt.format(now);
			joinTime = sdfNow.format(now);

			sql = "insert into WORKINGPARTTIMERS VALUES ('" + nm + "','" + pw + "','" + joinTime + "')";
			sql2 = "insert into WORKTIME VALUES ('" + dt + "','" + nm + "', '" + pw + "','" + joinTime
					+ "', '0','0','0')";
			boolean b = stmt.execute(sql);
			boolean b2 = stmt.execute(sql2);

			if (!b) {
				System.out.println("JOIN SUCCSESS.\n");
				CompleteJoinFrame cjf = new CompleteJoinFrame();
				cjf.setName(nm);
				cjf.start();
			} else {
				System.out.println("JOIN FAIL.\n");
			}

			if (!b2) {
				System.out.println("CHECK JOIN TIME SUCCSESS.\n");

			} else {
				System.out.println("CHECK JOIN TIME FAIL.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("f");
		} catch (SQLException e) {
			System.out.println(e);

		}
	}
}
